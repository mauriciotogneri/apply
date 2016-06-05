package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonGreaterEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonGreaterToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonLessEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonLessToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonNotEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicAndToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicNotToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicOrToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.AssignmentToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.SymbolToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.TypeOfToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.TypeReturnToken;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.AssignmentNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.FunctionCallNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.FunctionDefNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.NumberNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.OpenParenthesisNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.SymbolNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.TypeOfNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticAdditionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticDivisionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticModuleNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticMultiplicationNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticPowerNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticSubtractionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison.ComparisonEqualNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison.ComparisonGreaterEqualNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison.ComparisonGreaterNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison.ComparisonLessEqualNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison.ComparisonLessNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison.ComparisonNotEqualNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.conditional.ConditionalIfNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.logic.LogicAndNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.logic.LogicNotNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.logic.LogicOrNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NodeStack extends ArrayDeque<TreeNode>
{
    public void addToken(Token token)
    {
        if (token.isNumber())
        {
            push(new NumberNode(token));
        }
        else if (token instanceof ArithmeticToken)
        {
            addArithmeticNode(token);
        }
        else if (token instanceof ComparisonToken)
        {
            addComparisonNode(token);
        }
        else if (token instanceof LogicToken)
        {
            addLogicNode(token);
        }
        else if (token instanceof TypeOfToken)
        {
            addTypeOf(token);
        }
        else if (token instanceof SymbolToken)
        {
            push(new SymbolNode(token));
        }
        else if (token instanceof AssignmentToken)
        {
            addAssignment(token);
        }
        else if (token.isOpenParenthesis())
        {
            push(new OpenParenthesisNode(token));
        }
        else if (token.isFunctionDef())
        {
            push(new FunctionDefNode(token));
        }
        else if (token instanceof TypeReturnToken)
        {
            addFunctionDef();
        }
        else if (token.isIfElse() || token.isIf())
        {
            addConditionalIf(token);
        }
        else
        {
            throw new RuntimeException(token.lexeme());
        }
    }

    public void addFunctionCall(Token token)
    {
        List<TreeNode> parameters = new ArrayList<>();

        while (!isEmpty() && !peek().isOpenParenthesis())
        {
            parameters.add(pop());
        }

        pop();

        push(new FunctionCallNode(token, parameters));
    }

    public void addFunctionDef()
    {
        List<TreeNode> parameters = new ArrayList<>();

        TreeNode returnType = pop();

        if (!returnType.isSymbol())
        {
            throw new RuntimeException();
        }

        while (!isEmpty() && peek().isTypeOf())
        {
            parameters.add(pop());
        }

        TreeNode functionDef = pop();

        if (!functionDef.isFunctionDef())
        {
            throw new RuntimeException();
        }

        push(new FunctionDefNode(functionDef.token(), parameters, returnType));
    }

    private void addArithmeticNode(Token token)
    {
        if (size() >= 2)
        {
            TreeNode right = pop();
            TreeNode left = pop();

            if (right.isExpression() && left.isExpression())
            {
                if (token instanceof ArithmeticAdditionToken)
                {
                    push(new ArithmeticAdditionNode(token, left, right));
                }
                else if (token instanceof ArithmeticSubtractionToken)
                {
                    push(new ArithmeticSubtractionNode(token, left, right));
                }
                else if (token instanceof ArithmeticMultiplicationToken)
                {
                    push(new ArithmeticMultiplicationNode(token, left, right));
                }
                else if (token instanceof ArithmeticDivisionToken)
                {
                    push(new ArithmeticDivisionNode(token, left, right));
                }
                else if (token instanceof ArithmeticPowerToken)
                {
                    push(new ArithmeticPowerNode(token, left, right));
                }
                else if (token instanceof ArithmeticModuleToken)
                {
                    push(new ArithmeticModuleNode(token, left, right));
                }
                else
                {
                    throw new RuntimeException();
                }
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addComparisonNode(Token token)
    {
        if (size() >= 2)
        {
            TreeNode right = pop();
            TreeNode left = pop();

            if (right.isExpression() && left.isExpression())
            {
                if (token instanceof ComparisonEqualToken)
                {
                    push(new ComparisonEqualNode(token, left, right));
                }
                else if (token instanceof ComparisonNotEqualToken)
                {
                    push(new ComparisonNotEqualNode(token, left, right));
                }
                else if (token instanceof ComparisonLessToken)
                {
                    push(new ComparisonLessNode(token, left, right));
                }
                else if (token instanceof ComparisonLessEqualToken)
                {
                    push(new ComparisonLessEqualNode(token, left, right));
                }
                else if (token instanceof ComparisonGreaterToken)
                {
                    push(new ComparisonGreaterNode(token, left, right));
                }
                else if (token instanceof ComparisonGreaterEqualToken)
                {
                    push(new ComparisonGreaterEqualNode(token, left, right));
                }
                else
                {
                    throw new RuntimeException();
                }
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addLogicNode(Token token)
    {
        if (token instanceof LogicNotToken)
        {
            if (size() >= 1)
            {
                TreeNode expression = pop();

                if (expression.isExpression())
                {
                    push(new LogicNotNode(token, expression));
                }
                else
                {
                    throw new RuntimeException();
                }
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else if ((token instanceof LogicAndToken) ||
                (token instanceof LogicOrToken))
        {
            if (size() >= 2)
            {
                TreeNode left = pop();
                TreeNode right = pop();

                if (left.isExpression() && right.isExpression())
                {
                    if (token instanceof LogicAndToken)
                    {
                        push(new LogicAndNode(token, left, right));
                    }
                    else
                    {
                        push(new LogicOrNode(token, left, right));
                    }
                }
                else
                {
                    throw new RuntimeException();
                }
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addConditionalIf(Token token)
    {
        if (size() >= 3)
        {
            TreeNode ifFalse = pop();
            TreeNode ifTrue = pop();
            TreeNode condition = pop();

            if (ifFalse.isExpression() && ifTrue.isExpression() && condition.isExpression())
            {
                push(new ConditionalIfNode(token, condition, ifTrue, ifFalse));
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addTypeOf(Token token)
    {
        if (size() >= 2)
        {
            TreeNode type = pop();
            TreeNode name = pop();

            if (name.isSymbol() && type.isSymbol())
            {
                push(new TypeOfNode(token, name, type));
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addAssignment(Token token)
    {
        if (size() >= 2)
        {
            TreeNode expression = pop();
            TreeNode definition = pop();

            if (expression.isExpression())
            {
                push(new AssignmentNode(token, definition, expression));
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }
}