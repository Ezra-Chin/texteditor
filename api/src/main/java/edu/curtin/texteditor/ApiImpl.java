package edu.curtin.texteditor;

import edu.curtin.texteditor.api.Api;
import java.util.Locale;

public class ApiImpl implements Api
{
    private final Locale locale;

    public ApiImpl(Locale locale)
    {
        this.locale = locale;
    }

    @Override
    public Locale getLocale()
    {
        return locale;
    }
}