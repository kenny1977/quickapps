package com.yoavst.quickapps.desktop.modules

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import com.yoavst.quickapps.R
import com.yoavst.quickapps.desktop.BaseModuleView
import com.yoavst.quickapps.tools.amPmInNotifications
import com.yoavst.quickapps.tools.notificationShowContent
import com.yoavst.quickapps.tools.startActivityOnNotification

/**
 * Created by yoavst.
 */
public class NotificationsModuleView: BaseModuleView {

    public constructor(context: Context) : super(context) {
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    override fun init() {
        super.init()
        if (!isInEditMode()) {
            addSettingView(R.string.music_listener_title, R.string.music_listener_subtitle) {
                getContext().startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
            }
            addSettingView(R.string.privacy_title, R.string.privacy_subtitle, getContext().notificationShowContent) {
                getContext().notificationShowContent = it!!
                toastSuccess()
            }
            addSettingView(R.string.auto_launch_title, R.string.auto_launch_subtitle, getContext().startActivityOnNotification) {
                getContext().startActivityOnNotification = it!!
                toastSuccess()
            }
            addSettingView(R.string.am_pm_title, R.string.am_pm_subtitle, getContext().amPmInNotifications) {
                getContext().amPmInNotifications = it!!
                toastSuccess()
            }
        }
    }

    override fun getName(): Int = R.string.notification_module_name

    override fun getIcon(): Int = R.drawable.qcircle_icon_notifications
}