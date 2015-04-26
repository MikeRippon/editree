package uk.co.littlemike.editree.text;

import org.junit.Before;
import org.junit.Test;
import uk.co.littlemike.editree.language.expressions.BooleanConstant;
import uk.co.littlemike.editree.language.expressions.IntegerConstant;
import uk.co.littlemike.editree.language.expressions.StringConstant;
import uk.co.littlemike.editree.language.statements.VariableDeclaration;
import uk.co.littlemike.editree.language.types.Types;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VariableDeclarationRenderingTests {

    private SimpleStatementRenderer renderer;

    @Before
    public void setUp() {
        renderer = new SimpleStatementRenderer();
    }

    @Test
    public void shouldRenderUninitialisedIntegerDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.Integer, "myVariable");

        // Then
        assertThat(renderer.render(declaration), equalTo("Integer myVariable;"));
    }

    @Test
    public void shouldRenderUninitialisedStringDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.String, "myString");

        // Then
        assertThat(renderer.render(declaration), equalTo("String myString;"));
    }

    @Test
    public void shouldRenderUninitialisedBooleanDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.Boolean, "myBool");

        // Then
        assertThat(renderer.render(declaration), equalTo("Boolean myBool;"));
    }

    @Test
    public void shouldRenderInitialisedIntegerVariableDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.Integer, "myInt", new IntegerConstant(5));

        // Then
        assertThat(renderer.render(declaration), equalTo("Integer myInt = 5;"));
    }

    @Test
    public void shouldRenderInitialisedStringVariableDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.String, "myString", new StringConstant("Hello world!"));

        // Then
        assertThat(renderer.render(declaration), equalTo("String myString = \"Hello world!\";"));
    }

    @Test
    public void shouldRenderInitialisedBooleanVariableDeclaration() {
        // Given
        VariableDeclaration declaration = new VariableDeclaration(Types.Boolean, "myBool", BooleanConstant.TRUE);

        // Then
        assertThat(renderer.render(declaration), equalTo("Boolean myBool = true;"));
    }
}
