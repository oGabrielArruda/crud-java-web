package Logradouro;
import InfoCidade.InfoCidade;
import InfoCidade.InfoEstado.InfoEstado;
public class Logradouro
{
    protected String bairro;
    protected String complemento;
    protected String cidade;
    protected String logradouro;
    protected InfoEstado estado_info;
    protected String cep;
    protected InfoCidade cidade_info;
    protected String estado;

    public void setBairro(String bairro) throws Exception
    {
        if(bairro == null || bairro.length() == 0)
            throw new Exception("Bairro invalido");
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) throws Exception
    {
        if(complemento == null || complemento.length() == 0)
            throw new Exception("Complemento invalido");
    }
    public void setCidade(String cidade) throws Exception
    {
        if(cidade == null || cidade.length() == 0)
            throw new Exception("Cidade invalida");
        this.cidade = cidade;
    }

    public void setLogradouro(String logradouro) throws Exception
    {
        if(logradouro == null || logradouro.length() == 0)
            throw new Exception("Logradouro invalido");
        this.logradouro = logradouro;
    }

    public void setEstado_info(InfoEstado estado_info) throws Exception
    {
        if(estado_info == null)
            throw new Exception("Estado_info invalido");
        this.estado_info = (InfoEstado)estado_info.clone();
    }

    public void setCep(String cep) throws Exception
    {
        if(cep == null || cep.length() == 0)
            throw new Exception("Cep invalido");
        this.cep = cep;
    }

    public void setCidade_info(InfoCidade cidade_info) throws Exception
    {
        if(cidade_info == null)
            throw new Exception("Cidade ivalida");
        this.cidade_info = (InfoCidade) cidade_info.clone();
    }

    public void setEstado(String estado) throws Exception
    {
        if(estado == null || estado.length() == 0)
            throw new Exception("Estado invalido");
        this.estado = estado;
    }

    public String getBairro() { return this.bairro; }
    public String getComplemento() { return this.complemento; };
    public String getCidade() { return this.cidade; }
    public String getLogradouro() { return this.logradouro; }
    public InfoEstado getEstado_info() { return  (InfoEstado) this.estado_info.clone(); }
    public String getCep() { return this.cep; }
    public InfoCidade getCidade_info() { return (InfoCidade) this.cidade_info.clone(); };
    public String getEstado() { return this.estado; }

    public Logradouro(String bairro, String cidade, String logradouro, InfoEstado estado_info,
                      String cep, InfoCidade cidade_info, String estado) throws Exception
    {
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setLogradouro(logradouro);
        this.setEstado_info(estado_info);
        this.setCep(cep);
        this.setCidade_info(cidade_info);
        this.setEstado(estado);
    }

    public Logradouro(){}

    public String toString ()
    {
        return "Logradouro: "+
                this.logradouro+
                "\nComplemento: "+
                this.complemento+
                "\nCidade.....: "+
                this.cidade+
                " / "+
                this.cidade_info+
                "\nEstado.....: "+
                this.estado+
                " / "+
                this.estado_info+
                "\nC.E.P......: "+
                this.cep +
                "\nEstado......" +
                this.estado;
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;
        if (!(obj instanceof Logradouro))
            return false;

        Logradouro cep = (Logradouro)obj;

        if (!this.logradouro.equals(cep.logradouro))
            return false;

        if ((this.complemento==null && cep.complemento!=null) ||
                (this.complemento!=null && cep.complemento==null) ||
                !this.complemento.equals(cep.complemento))
            return false;

        if (!this.cidade.equals(cep.cidade))
            return false;

        if (!this.cidade_info.equals(cep.cidade_info))
            return false;

        if (!this.estado.equals(cep.estado))
            return false;

        if (!this.estado_info.equals(cep.estado_info))
            return false;

        if (!this.cep.equals(cep.cep))
            return false;
        if (!this.estado.equals(cep.estado))
            return false;

        return true;
    }

    public int hashCode ()
    {
        int ret=1;

        ret = 2*ret + this.logradouro .hashCode();

        if (this.complemento!=null)
            ret = 2*ret + this.complemento.hashCode();

        ret = 2*ret + this.cidade     .hashCode();
        ret = 2*ret + this.cidade_info.hashCode();
        ret = 2*ret + this.estado     .hashCode();
        ret = 2*ret + this.estado_info.hashCode();
        ret = 2*ret + this.cep        .hashCode();
        ret = 2*ret + this.estado        .hashCode();

        return ret;
    }

    public Logradouro (Logradouro modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.logradouro  = modelo.logradouro;
        this.complemento = modelo.complemento;
        this.cidade      = modelo.cidade;
        this.cidade_info = (InfoCidade)modelo.cidade_info.clone();
        this.estado      = modelo.estado;
        this.estado_info = (InfoEstado)modelo.estado_info.clone();
        this.cep         = modelo.cep;
        this.estado         = modelo.estado;
    }

    public Object clone ()
    {
        Logradouro ret=null;

        try
        {
            ret = new Logradouro (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
