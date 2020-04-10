package InfoCidade;

public class InfoCidade implements Cloneable
{
    public String area_km2;
    public String codigo_ibge;

    public void setArea_km2(String area_km2) throws  Exception
    {
        if(area_km2 == null || area_km2.length() == 0)
            throw new Exception("Area nula");
        this.area_km2 = area_km2;
    }

    public void setCodigo_ibge(String codigo_ibge) throws Exception
    {
        if(codigo_ibge == null || codigo_ibge.length() == 0)
            throw new Exception("Codigo nulo");
        this.codigo_ibge = codigo_ibge;
    }

    public String getArea_km2()
    {
        return this.area_km2;
    }

    public String getCodigo_ibge()
    {
        return this.codigo_ibge;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(obj.getClass() != this.getClass())
            return false;
        if(this == obj)
            return true;
        InfoCidade outraInfoCidade = (InfoCidade) obj;
        if(!this.codigo_ibge.equals(outraInfoCidade.codigo_ibge))
            return false;
        if(!this.area_km2.equals(outraInfoCidade.area_km2))
            return false;
        return true;
    }

    public String toString()
    {
        String ret = "";
        ret += "Area km2: " + this.area_km2 + "\n";
        ret += "Codigo Ibge " + this.codigo_ibge;
        return ret;
    }

    public int hashCode()
    {
        int ret = 135;
        ret = ret * 17 + this.codigo_ibge.hashCode();
        ret = ret * 17 + this.area_km2.hashCode();
        if (ret < 0)
            ret = -ret;
        return ret;
    }

    public InfoCidade(InfoCidade modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo nulo");
        this.codigo_ibge = modelo.codigo_ibge;
        this.area_km2 = modelo.codigo_ibge;
    }

    public InfoCidade clone()
    {
        InfoCidade ret = null;
        try
        {
            ret = new InfoCidade(this);
        }
        catch (Exception ex)
        { }
        return ret;
    }
}
