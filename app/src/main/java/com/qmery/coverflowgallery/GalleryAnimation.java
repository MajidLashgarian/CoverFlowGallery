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

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Author: Majid Lashgarian
 * Date: 12/1/15
 *
 * Custom Animation for Gallery
 * */
public class GalleryAnimation extends Animation
{

    private int mMaxRotationAngle = 180;

    private int mMaxZoom = 800;
    /** value of rotation of view in gallery */
    private int m_rotation = 0 ;

    /** Camera for changing object in linear layout */
    private Camera m_camera = new Camera();

    /** Height of destination View */
    private int m_height = 0 ;

    /** Width of destination View*/
    private int m_width = 0 ;

    private int m_setTranslateX = 0 ;
    /**
     * Author: Majid Lashgarian
     * Date: 12/1/15
     *
     * */
    public GalleryAnimation()
    {
        super();

        setFillEnabled(true);
        setFillAfter(true);
    }



    /**
     * Author: Majid Lashgarian
     * Date: 12/1/15
     *
     * @param interpolatedTime
     * @param t
     * */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t)
    {

        t.clear();
        t.setTransformationType(Transformation.TYPE_MATRIX);
        m_camera.save();
        final Matrix imageMatrix = t.getMatrix();

        final int height = m_height;
        final int width = m_width;
        final int rotation = Math.abs(m_rotation);

//        m_camera.translate(10.0f, 0.0f, 100.0f);

//        if(m_rotation >  0 )
//        {
            final float zoomAmount = (float) (mMaxZoom * rotation / mMaxRotationAngle);
            m_camera.translate(0.0f, 0.0f, zoomAmount);
//        }


        m_camera.rotateY(m_rotation);
        m_camera.getMatrix(imageMatrix);
        imageMatrix.preTranslate(-(width / 2.0f), -(height / 2.0f));
        imageMatrix.postTranslate((width / 2.0f), (height / 2.0f));
        m_camera.restore();

    }

    /**
     * Author: Majid Lashgarian
     * Date: 12/1/15
     *
     * @param _rotation rotate angle for rotate view
     * */
    public void set_rotation(int _rotation)
    {
        m_rotation = _rotation ;
    }

    /**
     * Author: Majid Lashgarian
     * Date: 12/1/15
     *
     * @param _height _height of View which animate execute on that
     * */
    public void set_height(int _height)
    {
        m_height = _height ;
    }

    /**
     * Author: Majid Lashgarian
     * Date: 12/1/15
     *
     * @param _width _width of View which animate execute on that
     * */
    public void set_width(int _width)
    {
        m_width = _width;
    }



}
