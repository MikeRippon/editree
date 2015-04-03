package uk.co.littlemike.editor.text;

import uk.co.littlemike.editor.language.statements.InitialisedVariableDeclaration;
import uk.co.littlemike.editor.language.statements.IntegerConstant;
import uk.co.littlemike.editor.language.statements.VariableDeclaration;

public class TextRenderer {
    public String render(IntegerConstant integer) {
        return Integer.toString(integer.getValue());
    }

    public String render(VariableDeclaration declaration) {
        return renderTypeAndName(declaration) + ";";
    }

    public String render(InitialisedVariableDeclaration declaration) {
        return renderTypeAndName(declaration) + " = " + render(declaration.getInitialValue()) + ";";
    }

    private String renderTypeAndName(VariableDeclaration declaration) {
        return declaration.getType().getName() + " " + declaration.getName();
    }
}
