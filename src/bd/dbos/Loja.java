package bd.dbos;

public class Loja implements Cloneable {
    private int codigo, cep, numero, qtdFuncionarios;
    private String nome, complemento, telefone, categoria;

    /**
     * Construtor vazio.
     */
    public Loja() {

    }

    /**
     * Construtor da classe loja. Recebe os respectivos parâmetros e chama os
     * métodos que setam os valores.
     * 
     * @param codigo          código da loja
     * @param nome            nome da loja
     * @param cep             cep da loja
     * @param numero          numero da loja
     * @param complemento     complemento da loja
     * @param telefone        telefone da loja
     * @param categoria       categoria da loja
     * @param qtdFuncionarios quantidade de funcionários da loja
     * @throws Exception caso algum valor seja inválido
     */
    public Loja(int codigo, String nome, int cep, int numero, String complemento, String telefone, String categoria,
            int qtdFuncionarios) throws Exception {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCep(cep);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setTelefone(telefone);
        this.setCategoria(categoria);
        this.setQtdFuncionarios(qtdFuncionarios);
    }

    /**
     * Pega o valor do atributo Código
     * 
     * @return o código da respectiva loja
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Pega o valor do atributo Nome
     * 
     * @return o nome da respectiva loja
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Pega o valor do atributo cep
     * 
     * @return o cep da respectiva loja
     */
    public Int getCep() {
        return this.cep;
    }

    /**
     * Pega o valor do atributo numero
     * 
     * @return o numero da respectiva loja
     */
    public Int getNumero() {
        return this.numero;
    }

    /**
     * Pega o valor do atributo complemento
     * 
     * @return o complemento da respectiva loja
     */
    public String getComplemento() {
        return this.complemento;
    }

    /**
     * Pega o valor do atributo Telefone
     * 
     * @return o telefone da respectiva loja
     */
    public String getTelefone() {
        return this.telefone;
    }

    /**
     * Pega o valor do atributo Categoria
     * 
     * @return a categoria da respectiva loja
     */
    public String getCategoria() {
        return this.categoria;
    }

    /**
     * Pega o valor do atributo qtdFuncionarios
     * 
     * @return a quantidade de funcionários da respectiva loja
     */
    public int getQtdFuncionarios() {
        return this.qtdFuncionarios;
    }

    /**
     * Seta o valor do atributo código
     * 
     * @param codigo o código da loja desejada
     * @throws Exception caso o código negativo, ou maior que 5000
     */
    public void setCodigo(int codigo) throws Exception {
        if (codigo <= 0 || codigo > 5000) {
            throw new Exception("Código deve estar entre 0 e 5000");
        }

        this.codigo = codigo;
    }

    /**
     * Seta o valor do atributo nome
     * 
     * @param nome o nome da loja desejada
     * @throws Exception caso a string nome seja nula
     */
    public void setNome(String nome) throws Exception {
        if (nome == null)
            throw new Exception("Nome inválido!");
        this.nome = nome;
    }

    /**
     * 
     * @param cep o cep da loja desejada
     * @throws Exception caso o cep seja inválido
     */
    public void setCep(int cep) throws Exception {
        if (cep < 10000000 || cep > 1999999)
            throw new Exception("Cep inválido!");
        this.cep = cep;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Seta o valor do atributo complemento
     * 
     * @param complemento o complemento da loja desejada
     * @throws Exception caso a string complemento seja nula
     */
    public void setComplemento(String complemento) throws Exception {
        if (complemento == null)
            throw new Exception("complemento inválido!");
        this.complemento = complemento;
    }

    /**
     * Seta o valor do atributo telefone
     * 
     * @param telefone o telefone da loja desejada
     * @throws Exception caso a string telefone seja nula
     */
    public void setTelefone(String telefone) throws Exception {
        if (telefone == null)
            throw new Exception("Telefone inválido!");
        this.telefone = telefone;
    }

    /**
     * Seta o valor do atributo categoria
     * 
     * @param categoria o categoria da loja desejada
     * @throws Exception caso a string categoria seja nula
     */
    public void setCategoria(String categoria) throws Exception {
        if (categoria == null)
            throw new Exception("Categoria inválida!");
        this.categoria = categoria;
    }

    /**
     * Seta o valor do atributo qtdFuncionarios
     * 
     * @param qtdFuncionarios a quantidade de funcionários da loja desejada
     */
    public void setQtdFuncionarios(int qtdFuncionarios) throws Exception {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    /**
     * Retorna o código hash da instância
     */
    public int hashCode() {
        int ret = 23;
        ret = ret * 7 + Integer.valueOf(this.codigo).hashCode();
        ret = ret * 7 + new String(this.nome).hashCode();
        ret = ret * 7 + Integer.valueOf(this.cep).hashcode();
        ret = ret * 7 + Integer.valueOf(this.numero).hashCode();
        ret = ret * 7 + new String(this.complemento).hashCode();
        ret = ret * 7 + new String(this.telefone).hashCode();
        ret = ret * 7 + new String(this.categoria).hashCode();
        ret = ret * 7 + Integer.valueOf(this.qtdFuncionarios).hashCode();

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    /**
     * Retorna os valores da classe em formato de string
     */
    public String toString() {
        String ret = "";
        ret += "Código:" + this.codigo + "/n";
        ret += "Nome:" + this.nome + "/n";
        ret += "Cep:" + this.cep + "/n";
        ret += "Numero" + this.numero + "/n";
        ret += "Complemento:" + this.complemento + "/n";
        ret += "Telefone:" + this.telefone + "/n";
        ret += "Categoria:" + this.categoria + "/n";
        ret += "Quantidade de funcionários:" + this.qtdFuncionarios + "/n";

        return ret;
    }

    /**
     * Verifica se a instância é igual a outra passada como parâmetro
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Loja))
            return false;

        Loja loja = (loja) obj;
        if (this.codigo != loja.codigo)
            return false;
        if (!(this.nome.equals(loja.nome)))
            return false;
        if (this.cep != loja.cep)
            return false;
        if (this.numero != loja.numero)
            return false;
        if (!(this.complemento.equals(loja.complemento)))
            return false;
        if (!(this.telefone.equals(loja.telefone)))
            return false;
        if (!(this.categoria.equals(loja.categoria)))
            return false;
        if (this.qtdFuncionarios != loja.qtdFuncionarios)
            return false;
        return true;
    }

    /**
     * Construtor de cópia da classe.
     * 
     * @param modelo a instância que será copiada.
     */
    public loja(loja modelo) {
        this.codigo = modelo.codigo;
        this.nome = modelo.nome;
        this.cep = modelo.cep;
        this.numero = modelo.numero;
        this.complemento = modelo.complemento;
        this.telefone = modelo.telefone;
        this.categoria = modelo.categoria;
        this.qtdFuncionarios = modelo.qtdFuncionarios;
    }

    /**
     * Clona a instância.
     */
    public Object clone() {
        loja ret = null;
        try {
            ret = new loja(this);
        } catch (Exception ex) {
        }

        return ret;
    }
}