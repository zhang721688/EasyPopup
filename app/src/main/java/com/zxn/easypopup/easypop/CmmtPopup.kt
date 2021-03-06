package com.zxn.easypopup.easypop

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.SizeUtils
import com.zxn.easypopup.R
import com.zxn.popup.BasePopup

/**
 * Created by zyyoona7 on 2018/3/12.
 *
 * PopupWindow 中存在 EditText 隐藏键盘方法不起作用，只有 toggle 键盘方法才起作用
 * 注：建议由 EditText 需求的弹窗使用 DialogFragment
 */
class CmmtPopup(context: Context?) : BasePopup<CmmtPopup>() {
    private var mCancelListener: View.OnClickListener? = null
    private var mOkListener: View.OnClickListener? = null
    var mCancelTv: AppCompatTextView? = null
    var mOkTv: AppCompatTextView? = null
    var mEditText: AppCompatEditText? = null
    override fun initAttributes() {
        setContentView(R.layout.layout_cmmt, ViewGroup.LayoutParams.MATCH_PARENT, SizeUtils.dp2px(150f))
        setFocusAndOutsideEnable(true)
                .setBackgroundDimEnable(true)
                .setAnimationStyle(R.style.BottomPopAnim)
                .setDimValue(0.5f)
                .setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED)
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }



    fun setOnCancelClickListener(listener: View.OnClickListener?): CmmtPopup {
        mCancelListener = listener
        return this
    }

    fun setOnOkClickListener(listener: View.OnClickListener?): CmmtPopup {
        mOkListener = listener
        return this
    }

    fun showSoftInput(): CmmtPopup {
        if (mEditText != null) {
            mEditText!!.post { KeyboardUtils.showSoftInput(mEditText) }
        }
        return this
    }

    fun hideSoftInput(): CmmtPopup {
        if (mEditText != null) {
            mEditText!!.post { KeyboardUtils.hideSoftInput(mEditText) }
        }
        return this
    }

    companion object {
        fun create(context: Context?): CmmtPopup {
            return CmmtPopup(context)
        }
    }

    init {
        setContext(context)
    }

    override fun initViews(view: View?, popup: CmmtPopup) {
        mCancelTv = findViewById(R.id.tv_cancel)
        mOkTv = findViewById(R.id.tv_ok)
        mEditText = findViewById(R.id.et_cmmt)
        mCancelTv!!.setOnClickListener(mCancelListener)
        mOkTv!!.setOnClickListener(mOkListener)
    }

}