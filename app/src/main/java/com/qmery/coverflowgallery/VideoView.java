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
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 *
 * Class Video View
 * View for Video in Cover Flow
 * */
public class VideoView extends RelativeLayout {

    private Context m_context; /** main context which hold this view */
    private ImageView thumbnail ; /** Video thumbnail picture  */
    private String time ; /** Time of video */
    private String title ; /** Title of Video */
    private String description; /** Description of video */

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     *  @param context parent View
     *
     * Default Constructor
     * */
    VideoView(Context context)
    {
        super(context);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param context parent View
     * @param attrs Attribute Set which pass to it
     *
     * Default Constructor
     * */
    VideoView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }



}

