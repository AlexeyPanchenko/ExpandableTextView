package ru.alexpan.expandabletextview

import android.content.Context
import android.text.SpannableStringBuilder
import android.util.AttributeSet
import android.widget.TextView

class ExpandableTextView @JvmOverloads constructor(
        context: Context?,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    private var trimIndex = 200
    private var button = "..."
    private var trim = true
    private var trimmedText: CharSequence? = null
    private var originalText: CharSequence? = null
    private var bufferType: TextView.BufferType? = null

    /*constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val array = context?.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView)
        array?.let { trimIndex = it.getInt(R.styleable.ExpandableTextView_trimLength,  200) }
        array?.recycle()

        setOnClickListener {
            trim = !trim
            updateText()
            requestFocusFromTouch()
            text
        }
    }*/

    init {
        val array = context?.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView)
        array?.let { trimIndex = it.getInt(R.styleable.ExpandableTextView_trim_length,  200) }
        array?.recycle()

        setOnClickListener {
            trim = !trim
            updateText()
            requestFocusFromTouch()
            text
        }
    }


    override fun setText(text: CharSequence?, type: BufferType?) {
        originalText = text
        trimmedText = getTrimmedText()
        bufferType = type
        updateText()
    }

    fun getOriginalText() = originalText

    fun setTrimLength(trimLength: Int) {
        trimIndex = trimLength
        trimmedText = getTrimmedText()
        updateText()
    }

    fun getTrimLength() = trimIndex

    private fun getTrimmedText(): CharSequence? {
        return if (originalText != null && originalText!!.length > trimIndex) {
            SpannableStringBuilder(originalText, 0, trimIndex + 1)/*.append(button)*/
        } else {
            originalText
        }
    }

    private fun updateText() {
        super.setText(getActualText(), bufferType)
    }

    private fun getActualText() = if (trim) trimmedText else originalText
}