package compiladores.gals;

import java.util.*;

public class Semantico implements Constants {

    private final Stack<String> pilha_tipos   = new Stack<>();
    private final Stack<String> pilha_rotulos = new Stack<>();
    private final Map<String,String> tabela_simbolos = new LinkedHashMap<>();
    private final List<String> lista_identificadores = new ArrayList<>();
    private String tipo = "";
    private String operador_relacional = "";
    private int proxRotulo = 1;

    private final StringBuilder code = new StringBuilder();

    private String novoRotulo() { return "L" + (proxRotulo++); }

    public void executeAction(int action, Token token) throws SemanticError {
        switch (action) {
            case 100: acao100(); break;
            case 101: acao101(); break;
            case 102: acao102(); break;

            case 103: acao103(token); break;
            case 104: acao104(token); break;
            case 105: acao105(token); break;

            case 106: acao106(); break;
            case 107: acao107(); break;
            case 108: acao108(); break;
            case 109: acao109(); break;
            case 110: acao110(); break;

            case 111: acao111(token); break;
            case 112: acao112(); break;

            case 113: acao113(); break;
            case 114: acao114(); break;
            case 115: acao115(); break;
            case 116: acao116(); break;
            case 117: acao117(); break;

            case 118: acao118(); break;

            case 119: acao119(); break;
            case 120: acao120(token); break;
            case 121: acao121(token); break;
            case 122: acao122(); break;

            case 123: acao123(token); break;
            case 124: acao124(token); break;

            case 125: acao125(token); break;
            case 126: acao126(); break;
            case 127: acao127(); break;

            case 128: acao128(); break;
            case 129: acao129(token); break;

            case 130: acao130(token); break;

            default:
                break;
        }
    }

    private void acao100() {
        code.append(".assembly extern mscorlib {}\n")
                .append(".assembly _programa{}\n")
                .append(".module _programa.exe\n")
                .append(".class public _unica{\n")
                .append(".method static public void _principal(){\n")
                .append(".entrypoint\n");
    }

    private void acao101() {
        code.append("ret\n")
                .append("}\n")
                .append("}\n");
    }

    private void acao102() {
        String t = pilha_tipos.pop();
        if ("int64".equals(t)) code.append("conv.i8\n");
        code.append("call void [mscorlib]System.Console::Write(");
        if ("int64".equals(t))      code.append("int64");
        else if ("float64".equals(t)) code.append("float64");
        else if ("string".equals(t))  code.append("string");
        else if ("bool".equals(t))    code.append("bool");
        code.append(")\n");
    }

    private void acao103(Token token) {
        pilha_tipos.push("int64");
        code.append("ldc.i8 ").append(token.getLexeme()).append("\n");
        code.append("conv.r8\n");
    }

    private void acao104(Token token) {
        pilha_tipos.push("float64");
        code.append("ldc.r8 ").append(token.getLexeme().replace(',', '.')).append("\n");
    }

    private void acao105(Token token) {
        pilha_tipos.push("string");
        code.append("ldstr ").append(token.getLexeme()).append("\n");
    }

    private void acao106() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();
        String r;

        if (("float64".equals(t1) && "int64".equals(t2)) ||
                ("int64".equals(t1) && "float64".equals(t2)) ||
                ("float64".equals(t1) && "float64".equals(t2))) {
            code.append("add\n");
            r = "float64";
        } else if ("int64".equals(t1) && "int64".equals(t2)) {
            code.append("add\n");
            r = "int64";
        } else if ("string".equals(t1) && "string".equals(t2)) {
            code.append("call string [mscorlib]System.String::Concat(string, string)\n");
            r = "string";
        } else {
            throw new SemanticError("tipos incompatíveis em expressão aritmética", 0);
        }
        pilha_tipos.push(r);
    }

    private void acao107() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();
        String r;

        if (("float64".equals(t1) && "int64".equals(t2)) ||
                ("int64".equals(t1) && "float64".equals(t2)) ||
                ("float64".equals(t1) && "float64".equals(t2))) {
            code.append("sub\n");
            r = "float64";
        } else if ("int64".equals(t1) && "int64".equals(t2)) {
            code.append("sub\n");
            r = "int64";
        } else {
            throw new SemanticError("tipos incompatíveis em expressão aritmética", 0);
        }
        pilha_tipos.push(r);
    }

    private void acao108() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();
        String r;

        if (("float64".equals(t1) && "int64".equals(t2)) ||
                ("int64".equals(t1) && "float64".equals(t2)) ||
                ("float64".equals(t1) && "float64".equals(t2))) {
            code.append("mul\n");
            r = "float64";
        } else if ("int64".equals(t1) && "int64".equals(t2)) {
            code.append("mul\n");
            r = "int64";
        } else {
            throw new SemanticError("tipos incompatíveis em expressão aritmética", 0);
        }
        pilha_tipos.push(r);
    }

    private void acao109() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();
        String r;

        if (("float64".equals(t1) && "int64".equals(t2)) ||
                ("int64".equals(t1) && "float64".equals(t2)) ||
                ("float64".equals(t1) && "float64".equals(t2))) {
            code.append("div\n");
            r = "float64";
        } else if ("int64".equals(t1) && "int64".equals(t2)) {
            code.append("div\n");
            r = "int64";
        } else {
            throw new SemanticError("tipos incompatíveis em expressão aritmética", 0);
        }
        pilha_tipos.push(r);
    }

    private void acao110() throws SemanticError {
        String t = pilha_tipos.pop();
        if ("int64".equals(t) || "float64".equals(t)) {
            code.append("ldc.i8 -1\n");
            code.append("conv.r8\n");
            code.append("mul\n");
            pilha_tipos.push(t);
        } else {
            throw new SemanticError("tipo incompatível para operador unário -", 0);
        }
    }

    private void acao111(Token token) {
        operador_relacional = token.getLexeme();
    }

    private void acao112() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();

        if ("==".equals(operador_relacional)) {
            code.append("ceq\n");
        } else if ("~=".equals(operador_relacional)) {
            code.append("ceq\n");
            code.append("ldc.i4.0\n");
            code.append("ceq\n");
        } else if ("<".equals(operador_relacional)) {
            code.append("clt\n");
        } else if (">".equals(operador_relacional)) {
            code.append("cgt\n");
        }
        pilha_tipos.push("bool");
    }

    private void acao113() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();
        if (!"bool".equals(t1) || !"bool".equals(t2)) {
            throw new SemanticError("tipos incompatíveis em expressão lógica", 0);
        }
        code.append("and\n");
        pilha_tipos.push("bool");
    }

    private void acao114() throws SemanticError {
        String t2 = pilha_tipos.pop();
        String t1 = pilha_tipos.pop();
        if (!"bool".equals(t1) || !"bool".equals(t2)) {
            throw new SemanticError("tipos incompatíveis em expressão lógica", 0);
        }
        code.append("or\n");
        pilha_tipos.push("bool");
    }

    private void acao115() {
        pilha_tipos.push("bool");
        code.append("ldc.i4.1\n");
    }

    private void acao116() {
        pilha_tipos.push("bool");
        code.append("ldc.i4.0\n");
    }

    private void acao117() throws SemanticError {
        String t = pilha_tipos.pop();
        if (!"bool".equals(t)) {
            throw new SemanticError("tipo incompatível para operador not", 0);
        }
        code.append("ldc.i4.1\n");
        code.append("xor\n");
        pilha_tipos.push("bool");
    }

    private void acao118() {
        code.append("ldstr \"\\n\"\n");
        code.append("call void [mscorlib]System.Console::Write(string)\n");
    }

    private void acao119() {
        for (String id : lista_identificadores) {
            tabela_simbolos.put(id, tipo);

            code.append(".locals (")
                    .append(tipo)
                    .append(" ")
                    .append(id)
                    .append(")\n");
        }

        lista_identificadores.clear();
    }

    private void acao120(Token token) {
        String lex = token.getLexeme();
        if ("int".equals(lex)) tipo = "int64";
        else if ("float".equals(lex)) tipo = "float64";
        else if ("string".equals(lex)) tipo = "string";
        else if ("bool".equals(lex)) tipo = "bool";
    }

    private void acao121(Token token) {
        String id = token.getLexeme();
        lista_identificadores.add(id);
    }

    private void acao122() throws SemanticError {
        String tExp = pilha_tipos.pop();
        String id = lista_identificadores.get(lista_identificadores.size() - 1);
        String tId = tabela_simbolos.get(id);
        if (tId == null) {
            throw new SemanticError("identificador não declarado: " + id, 0);
        }
        if ("int64".equals(tExp)) {
            code.append("conv.i8\n");
        }
        if ("float64".equals(tId) && "int64".equals(tExp)) {
            code.append("conv.r8\n");
        } else if (!tId.equals(tExp)) {
            throw new SemanticError("tipos incompatíveis em comando de atribuição", 0);
        }
        code.append("stloc ").append(id).append("\n");
        lista_identificadores.clear();
    }

    private void acao123(Token token) throws SemanticError {
        String id = token.getLexeme();
        String t = tabela_simbolos.get(id);
        if (t == null) {
            throw new SemanticError("identificador não declarado: " + id, token.getPosition());
        }
        if ("bool".equals(t)) {
            throw new SemanticError(id + " inválido para comando de entrada", token.getPosition());
        }
        code.append("call string [mscorlib]System.Console::ReadLine()\n");
        if ("int64".equals(t)) {
            code.append("call int64 [mscorlib]System.Int64::Parse(string)\n");
        } else if ("float64".equals(t)) {
            code.append("call float64 [mscorlib]System.Double::Parse(string)\n");
        }
        code.append("stloc ").append(id).append("\n");
    }

    private void acao124(Token token) {
        String s = token.getLexeme();
        code.append("ldstr ").append(s).append("\n");
        code.append("call void [mscorlib]System.Console::Write(string)\n");
    }

    private void acao125(Token token) throws SemanticError {
        String t = pilha_tipos.pop();
        if (!"bool".equals(t))
            throw new SemanticError("expressão incompatível em comando de seleção", token.getPosition());
        String L1 = novoRotulo();
        code.append("brfalse ").append(L1).append("\n");
        pilha_rotulos.push(L1);
    }

    private void acao126() {
        String L = pilha_rotulos.pop();
        code.append(L).append(":\n");
    }

    private void acao127() {
        String L2 = novoRotulo();
        code.append("br ").append(L2).append("\n");
        String L1 = pilha_rotulos.pop();
        code.append(L1).append(":\n");
        pilha_rotulos.push(L2);
    }

    private void acao128() {
        String L = novoRotulo();
        code.append(L).append(":\n");
        pilha_rotulos.push(L);
    }

    private void acao129(Token token) throws SemanticError {
        String t = pilha_tipos.pop();
        if (!"bool".equals(t))
            throw new SemanticError("expressão incompatível em comando de repetição", token.getPosition());
        String L = pilha_rotulos.pop();
        code.append("brfalse ").append(L).append("\n");
    }

    private void acao130(Token token) throws SemanticError {
        String id = token.getLexeme();
        String ilType = tabela_simbolos.get(id);
        if (ilType == null)
            throw new SemanticError("identificador não declarado: " + id, token.getPosition());
        pilha_tipos.push(ilType);
        code.append("ldloc ").append(id).append("\n");
        if ("int64".equals(ilType)) code.append("conv.r8\n");
    }

    public String getCodigoGeradoS() {
        return code.toString();
    }
}