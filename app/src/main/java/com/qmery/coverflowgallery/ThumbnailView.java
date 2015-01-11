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
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 * <p/>
 * Class Video View
 * View for Video in Cover Flow
 */
public class ThumbnailView extends RelativeLayout
{
    /** main context which hold this view */
    private Context m_context;

    /** attributes which passed from xml */
    private AttributeSet m_attrs ;

    /** Video thumbnail picture */
    private ImageView m_thumbnail;

    /** Time of video */
    private TextView m_time;

    /** Title of Video */
    private TextView m_title;

    /** Description of video */
    private String m_description;

    /**Width of screenSize*/
    private int m_width;
    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param context parent View
     */
    public ThumbnailView(Context context)
    {
        super(context);
        initialView(context , null);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param context parent View
     * @param attrs   Attribute Set which pass to it
     */
    public ThumbnailView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initialView(context, attrs);
    }


    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param context parent View
     * @param attrs   Attribute Set which pass to it
     * @param def
     */
    public ThumbnailView(Context context, AttributeSet attrs, int def)
    {
        super(context, attrs, def);
        initialView(context, attrs);
    }


    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * initialize all class object
     *
     * @param context parent
     * @param attrs attribute for passing to child objects
     *
     */
    private void initialView(Context context , AttributeSet attrs )
    {
        m_context = context ;
        m_attrs = attrs ;
        m_thumbnail = new ImageView(m_context);
        m_time = new TextView(m_context) ;
        m_title = new TextView(m_context) ;
        m_description = "" ;

        setWillNotDraw(false);
        setImage();
        configTime();

        addView(m_thumbnail);
        addView(m_time);

    }

    /**
     * Author: Majid Lashgarian
     * Date; 10/1/15
     *
     * */
    private void configTime()
    {
        setTimeFromXML();
        m_time.setTextColor(Color.WHITE);
        m_time.setBackgroundColor(Color.argb(125, 0, 0, 0));

    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * set image from xml (getting from attribute set)
     * */
    private void setImage()
    {
        Drawable image;
        TypedArray ta = m_context.obtainStyledAttributes(m_attrs, R.styleable.ThumbnailView, 0, 0);
        try
        {
            image = ta.getDrawable(R.styleable.ThumbnailView_imageRes);
        }finally
        {
            ta.recycle();
        }
        setImage(image);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * Set Time from xml
     * */
    private void setTimeFromXML(){
        String time = "2:30" ;
        TypedArray ta = m_context.obtainStyledAttributes(m_attrs, R.styleable.ThumbnailView, 0, 0);
        try
        {
            time = ta.getString(R.styleable.ThumbnailView_timeVideo);
        }finally
        {
            ta.recycle();
        }
        setTime(time);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     */
    public void setTime(String time)
    {
        m_time.setText(time);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     */
    private void resizeChild()
    {
        if(m_width == getWidth())
            return ;
        m_width = getWidth() ;//width of display
        int height = getHeight() ;//height of display

        resizethumbnail(m_width, height);
        resizeTime(m_width, height);
        //TODO Also must implement resize title, time and other stuff here
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param width width of display
     * @param height height of display
     */
    private void resizeTime(int width, int height)
    {
        float rt_leftMargin   = 0.08f, //rt = ratio thumbnail left margin
                rt_topMargin  = 0.75f,
                rt_WidthMargin  = 0.1f,
                rt_heightMargin = 0.02f;

        RelativeLayout.LayoutParams layoutParam = (RelativeLayout.LayoutParams)m_time
                .getLayoutParams();
        layoutParam.height += (int)rt_heightMargin*height ;
        layoutParam.width += (int)rt_WidthMargin*width ;
        layoutParam.leftMargin = (int)(rt_leftMargin*width) ;
        layoutParam.topMargin =  (int)(rt_topMargin*height) ;
        m_time.setLayoutParams(layoutParam);

    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param width width of display
     * @param height height of display
     * */
    private void resizethumbnail(int width, int height)
    {
        float rt_leftMargin   = 0f, //rt = ratio thumbnail left margin
                rt_topMargin  = 0f,
                rt_WidthMargin  = 1.0f,
                rt_heightMargin = 1.0f;

        RelativeLayout.LayoutParams layoutParam = (RelativeLayout.LayoutParams)m_thumbnail
                .getLayoutParams();
        layoutParam.height = (int)rt_heightMargin*height ;
        layoutParam.width = (int)rt_WidthMargin*width ;
        layoutParam.leftMargin = (int)rt_leftMargin*width ;
        layoutParam.topMargin=  (int)rt_topMargin*height ;
        m_thumbnail.setLayoutParams(layoutParam);

    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param image drawble image  from resource manager
     * */
    public void setImage(Drawable image)
    {
        m_thumbnail.setImageDrawable(image);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param canvas instance of main canvas which pass from android for drawing
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        resizeChild();
        super.onDraw(canvas);
    }
}

