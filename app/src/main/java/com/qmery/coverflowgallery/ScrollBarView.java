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
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 *
 * Scroll Bar View
 * */
public class ScrollBarView extends HorizontalScrollView
{
    private int pictureIndex ; /** indexes to move to picture */

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/15
     *
     * */
    public ScrollBarView(Context context)
    {
        super(context);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/115
     *
     * */
    public ScrollBarView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    /**
     * Author: Majid Lashagrna
     * Date:11/3
     *
     * */
    public ScrollBarView(Context context, AttributeSet attrs, int def)
    {
        super(context, attrs , def);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/15
     *
     * @param l
     * @param t
     * @param oldl
     * @param oldt
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt)
    {
        int min = 100000 ;
        for(int i = 0 ; i < ((ListViewH)getChildAt(0)).getChildCount() ; i++){
            float x = ((ListViewH)getChildAt(0)).getChildAt(i).getX();
            float w = ((ListViewH)getChildAt(0)).getChildAt(i).getWidth();
            float diff = Math.abs(x-l) ;
            if( diff < min )
            {
                min = (int)diff ;
                pictureIndex = i ;
            }
        }
        super.onScrollChanged(l, t, oldl, oldt);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/15
     *
     * @param ev motion Event
     * */
    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        if(ev.getAction()==1) //touch end
        {
            float dx = ((ListViewH)getChildAt(0)).getChildAt(pictureIndex).getX() ;
           // super.scrollTo((int)dx , 0);

        }
        return super.onTouchEvent(ev);
    }
}
