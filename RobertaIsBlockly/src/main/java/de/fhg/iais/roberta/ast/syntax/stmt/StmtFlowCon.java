package de.fhg.iais.roberta.ast.syntax.stmt;

import de.fhg.iais.roberta.ast.syntax.Phrase;
import de.fhg.iais.roberta.dbc.DbcException;

public class StmtFlowCon extends Stmt {
    private final Flow flow;

    private StmtFlowCon(Flow flow) {
        super(Phrase.Kind.StmtFlowCon);
        this.flow = flow;
        setReadOnly();
    }

    public static StmtFlowCon make(Flow flow) {
        return new StmtFlowCon(flow);
    }

    public Flow getFlow() {
        return this.flow;
    }

    @Override
    public void toStringBuilder(StringBuilder sb, int indentation) {
        appendNewLine(sb, indentation, toString());
    }

    @Override
    public String toString() {
        return "StmtFlowCon [" + this.flow + "]";
    }

    public static enum Flow {
        CONTINUE, BREAK;

        public static Flow get(String s) {
            if ( "continue".equals(s) ) {
                return CONTINUE;
            } else if ( "break".equals(s) ) {
                return BREAK;
            } else {
                throw new DbcException("invalid binary operator: " + s);
            }
        }
    }

}
