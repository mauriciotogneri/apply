package com.mauriciotogneri.apply.compiler.code;

import com.mauriciotogneri.apply.compiler.syntactic.NodeStack;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class SourceCode
{
    private final NodeStack nodeStack;

    public SourceCode(NodeStack nodeStack)
    {
        this.nodeStack = nodeStack;
    }

    public String generate(String packageName, String className) throws Exception
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("package %s;\n\n", packageName));

        builder.append("import static com.mauriciotogneri.apply.experiment.Runtime.AnyOperations.*;\n");
        builder.append("import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.*;\n");

        builder.append("\n");

        builder.append(String.format("public class %s\n", className));
        builder.append("{\n");

        for (TreeNode node : nodeStack)
        {
            builder.append(node.sourceCode());
        }

        builder.append("}");

        return builder.toString();
    }
}