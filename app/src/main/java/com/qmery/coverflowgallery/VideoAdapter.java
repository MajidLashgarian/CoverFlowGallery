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

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Author: Majid Lashgarian
 * Date: 10/1/15
 * <p/>
 * VideoAdapter class inherit from base adapter for store
 * video thumbnail, title and video time for showing in a
 * horizontal list view(Cover flow).
 */
public class VideoAdapter extends BaseAdapter
{


    public ArrayList<ThumbnailView> videos = new ArrayList<ThumbnailView>();/** Videos which
 shows in cover flow */

    public VideoAdapter()
    {}

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @return number of video in adapter
     */
    @Override
    public int getCount()
    {
        return videos.size();
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @return return videoView which must show in cover flow
     */
    @Override
    public View getItem(int position)
    {
        return videos.get(position);
    }

    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param position position number of VideoView
     *
     * @return return VideoView ID
     */
    @Override
    public long getItemId(int position)
    {
        return position;
    }


    /**
     * Author: Majid Lashgarian
     * Date: 10/1/15
     *
     * @param position
     * @param convertView
     * @param parent      CoverFlow parent View
     *
     * @return return VideoView which at position
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
//        ThumbnailView newThump = new ThumbnailView( );
//        newThump.setImage(convertView.getContext().getResources().getDrawable(R.drawable.p1));
//        newThump.setTime("2:30");
//        videos.add(newThump);
        return videos.get(position);
    }

}
