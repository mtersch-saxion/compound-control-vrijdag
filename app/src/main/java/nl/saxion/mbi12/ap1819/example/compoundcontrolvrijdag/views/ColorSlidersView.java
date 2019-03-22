package nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import nl.saxion.mbi12.ap1819.example.compoundcontrolvrijdag.R;

public class ColorSlidersView extends LinearLayout {
    private Context context;
    private SeekBar sbRed, sbGreen, sbBlue;
    private ColorChangeListener listener;

    public ColorSlidersView(Context context) {
        super(context);
        init(context);
    }

    public ColorSlidersView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ColorSlidersView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ColorSlidersView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(final Context context) {
        this.context = context;

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_colorsliders, this);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                if (context instanceof Updatable) {
//                    Updatable updatable = (Updatable)context;
//                    updatable.update();
//                }
//
                if (listener != null) {
                    listener.onColorChanged();
                    if (seekBar.getProgress() == seekBar.getMax()) {
                        listener.onRedToMax();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setRed(int red) {
        sbRed.setProgress(clipValue(red, sbRed.getMax()));
    }

    public void setGreen(int green) {
        sbGreen.setProgress(clipValue(green, sbGreen.getMax()));
    }

    public void setBlue(int blue) {
        sbBlue.setProgress(clipValue(blue, sbBlue.getMax()));
    }

    public int getColor() {
        return Color.rgb(
                sbRed.getProgress(),
                sbGreen.getProgress(),
                sbBlue.getProgress()
        );
    }

    public void setColorChangeListener(ColorChangeListener listener) {
        this.listener = listener;
    }

    private int clipValue(int value, int maxValue) {
        return Math.max(0, Math.min(maxValue, value));
    }

    public interface ColorChangeListener {
        void onColorChanged();
        void onRedToMax();
    }
}
