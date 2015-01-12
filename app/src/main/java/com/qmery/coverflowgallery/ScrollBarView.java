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
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;

/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 * <p/>
 * Scroll Bar View
 */
public class ScrollBarView extends HorizontalScrollView
{
    private int pictureIndex; /** indexes to move to picture */


    private ArrayList<GalleryAnimation> m_rotateAnimations = new ArrayList<GalleryAnimation>();
    /**
     * Author: Majid Lashgarian
     * Date: 11/1/15
     */
    public ScrollBarView(Context context)
    {
        super(context);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/115
     */
    public ScrollBarView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    /**
     * Author: Majid Lashagrna
     * Date:11/3
     */
    public ScrollBarView(Context context, AttributeSet attrs, int def)
    {
        super(context, attrs, def);
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



        for(int i = 0; i < ((ListViewH) getChildAt(0)).getChildCount(); i++)
        {
            if(m_rotateAnimations.size() == i )
                m_rotateAnimations.add(new GalleryAnimation());
            View temp = ((ListViewH) getChildAt(0)).getChildAt(i) ;
            m_rotateAnimations.get(i).set_height(temp.getHeight());
            m_rotateAnimations.get(i).set_width(temp.getWidth());


            float x = temp.getX();
            float w = temp.getWidth();
            float diff = (x - l) - (getWidth()/2 -  w/2) ;

            if(diff < -100)
            {

                m_rotateAnimations.get(i).set_rotation(-(int)(diff/4.0f));
                pictureIndex = i;
            }else if (diff >  100 ){
                m_rotateAnimations.get(i).set_rotation(-(int)(diff/4.0f));
            }else{
                m_rotateAnimations.get(i).set_rotation(-(int)(diff/4.0f));
            }
            temp.startAnimation(m_rotateAnimations.get(i));
            ((ListViewH) getChildAt(0)).getChildAt(i).invalidate();
        }

        super.onScrollChanged(l, t, oldl, oldt);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 11/1/15
     *
     * @param ev motion Event
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        if(ev.getAction() == 1) //touch end{}
        {

        }
        return super.onTouchEvent(ev);
    }


}


