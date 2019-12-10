package tokopedia.app.abstraction.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tokopedia.app.abstraction.util.view.KeyboardUtils
import tokopedia.app.abstraction.util.ext.toast

abstract class BaseActivity: AppCompatActivity(), BaseView {

    /**
     * lifecycle method
     * @method contentView(): @return resLayoutId
     * @method initView()depe
     */
    abstract fun contentView(): Int
    abstract fun initView()
    abstract fun initObservable()

    /**
     * (optional, use it if needed)
     */
    protected lateinit var savedInstanceState: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            this.savedInstanceState = savedInstanceState
        }
        setContentView(contentView())
        initObservable()
        initView()
    }

    override fun onMessage(message: String?) {
        toast(message)
    }

    override fun onMessage(stringResId: Int) {
        onMessage(getString(stringResId))
    }

    /**
     * hide keyboard layout
     */
    override fun hideKeyboard() {
        return KeyboardUtils().hide(this)
    }

}