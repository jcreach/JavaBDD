package com.valday.GestionAgenceVoyage.Table;

public class Villes
{
    //region Private Attributs

    private int _id;

    private String _name;

    //endregion Private Attributs

    //region Public Attributs

    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public String get_name()
    {
        return _name;
    }

    public void set_name(String _name)
    {
        this._name = _name;
    }


    //endregion Public Attributs

    //region Constructors

    public Villes()
    {

    }

    public Villes(int id, String name)
    {
        this._id = id;
        this._name = name;
    }

    //endregion Constructors
}
