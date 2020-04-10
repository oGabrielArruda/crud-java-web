package InfoCidade.InfoEstado;

import InfoCidade.InfoCidade;

public class InfoEstado extends InfoCidade implements Cloneable
{
    protected String nome;

    public InfoEstado()
    {
        super();
    }

    public void setNome(String nome) throws Exception
    {
        if(nome == null || nome.length() == 0)
            throw new Exception("Nome nulo");
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;
        if(this == obj)
            return true;
        InfoEstado outroInfo = (InfoEstado) obj;

        if(!super.area_km2.equals(outroInfo.area_km2))
            return false;
        if(!super.codigo_ibge.equals(outroInfo.codigo_ibge))
            return false;
        if(!nome.equals(outroInfo.nome))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        String ret = "";
        ret += "Nome : " + this.nome + "\n";
        ret += "Area km2: " + super.area_km2 + "\n";
        ret += "Codigo Ibge: " + super.codigo_ibge + "\n";
        return ret;
    }

    public int hashCode()
    {
        int ret = 135;
        ret = ret * 17 + this.nome.hashCode();
        ret = ret * 17 + super.area_km2.hashCode();
        ret = ret * 17 + super.codigo_ibge.hashCode();
        if(ret < 0)
            ret = -ret;
        return ret;
    }

    public InfoEstado(InfoEstado modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo nulo");
        this.nome = modelo.nome;
        super.area_km2 = modelo.area_km2;
        super.codigo_ibge = modelo.codigo_ibge;
    }

    @Override
    public InfoEstado clone()
    {
        InfoEstado ret = null;
        try
        {
            ret = new InfoEstado(this);
        } catch (Exception ex){}
        return ret;
    }
}
