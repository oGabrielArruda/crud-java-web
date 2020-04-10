package InfoCidade;

public class InfoCidade implements Cloneable{
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
}
