package ast;

import java.util.*;
import visitor.*;

/**
 *  The AST Abstract class is the Abstract Syntax Tree representation;
 *  each node contains<ol><li> references to its kids, <li>its unique node number
 *  used for printing/debugging, <li>its decoration used for constraining
 *  and code generation, and <li>a label for code generation</ol>
 *  The AST is built by the Parser
 */
public abstract class AST {

    protected ArrayList<AST> kids;
    private static boolean calledOnce = false, secCall = true;
    private static AST parent;
    protected int nodeNum;
    protected AST decoration;
    // label for generated code of tree
    protected String label = "";

    protected AST parentNode = null;
    public static int NodeCount = 0;

    public AST() {
        if (!calledOnce) {
            calledOnce = true;
            parent = this;
            secCall = false;
        }
        else if (!secCall) {
            secCall = true;
            parentNode = parent;
        }
        kids = new ArrayList<AST>();
        NodeCount++;
        nodeNum = NodeCount;
    }
    public int depth() {
        int maxDepth = 0;
        for (AST kid : kids) {
            int kidDepth = kid.depth();
            if (kidDepth > maxDepth) {
                maxDepth = kidDepth;
            }
        }
        return maxDepth + 1;
    }

    public void setDecoration(AST t) {
        decoration = t;
    }

    public AST getDecoration() {
        return decoration;
    }

    public int getNodeNum() {
        return nodeNum;
    }

    /**
     *  get the AST corresponding to the kid
     *  @param i is the number of the needed kid; it starts with kid number one
     *  @return the AST for the indicated kid
     */
    public AST getKid(int i) {
        if ((i <= 0) || (i > kidCount())) {
            return null;
        }
        return kids.get(i - 1);
    }

    /**
     *  @return the number of kids at this node
     */
    public int kidCount() {
        return kids.size();
    }

    public ArrayList<AST> getKids() {
        return kids;
    }

    /**
     *  accept the visitor for this node - this method must be defined in each of
     *  the subclasses of AST
     *  @param v is the ASTVisitor visiting this node (currently, a printer,
     *  constrainer and code generator)
     *  @return the desired Object, as determined by the visitor
     */
    public abstract Object accept(ASTVisitor v);

    public abstract Object accept(OffsetVisitor v);

    public AST addKid(AST kid) {
        kid.parentNode = this;
        kids.add(kid);
        return this;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public int getLevel(){
        int level = 0;
        AST parent = this;
        while (parent != null) {
            level++;
            parent = parent.getParent();
        }
        return level;
    }
    private AST getParent(){
        return this.parentNode;
    }
}
