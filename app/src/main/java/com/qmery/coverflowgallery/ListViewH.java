/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 *
 * CoverFloW App
 * under GNU-GPL V3.0 License
 * License URL: http://choosealicense.com/licenses/gpl-3.0/
 *
 * Contact: Majid[at]Lashgarian[dot]ir
 * Skype: Majid.Lashgarian
 *
 * */
package com.qmery.coverflowgallery;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import java.util.ArrayList;

/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 *
 * List View Horizontal
 */
public class ListViewH extends LinearLayout
{

    /** Store main context */
    private Context m_context ;

    /**Store attributes get from xml */
    private AttributeSet m_attrs ;

    /** Adapter Object for store data*/
    private BaseAdapter m_adapter ;

    /** id which attached to main view */
    private ArrayList<Long> m_attachedID;

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * */
    public ListViewH(Context context)
    {
        super(context);
        initialize(context, null);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     */
    public ListViewH(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initialize(context, attrs);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * */
    public ListViewH(Context context, AttributeSet attrs, int def )
    {
        super(context, attrs, def);
        initialize(context, attrs);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * Initialize function for set option to linear layout
     */
    private void initialize(Context context, AttributeSet attrs)
    {
        m_context = context ;
        m_attrs = attrs;
        m_attachedID = new ArrayList<Long>();

        setOrientation(LinearLayout.HORIZONTAL); //set Orientation of linear layout
        setWillNotDraw(false);


    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * */
    public void setAdapter(BaseAdapter adapter)
    {
        m_adapter = adapter ;
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * Start for adding View to Linear Layout
     * */
    public void arrangeViews()
    {

        for(int i = 0 ; i < m_adapter.getCount() ; i++)
        {

            if(m_attachedID.indexOf(m_adapter.getItemId(i)) == -1 )
            {
                m_attachedID.add(m_adapter.getItemId(i));
                addView(m_adapter.getView(i, null, null));
            }// end of if
        }//end of for
    }// end of functin

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/15
     *
     * @return all videos
     *
     * */
    public BaseAdapter getAdapter()
    {
        return m_adapter ;
    }
 }
