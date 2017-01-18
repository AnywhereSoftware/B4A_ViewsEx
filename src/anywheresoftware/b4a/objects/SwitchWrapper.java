package anywheresoftware.b4a.objects;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.DesignerProperties;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Property;
import anywheresoftware.b4a.BA.RaisesSynchronousEvents;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("Switch")
@ActivityObject
@Events(values={"CheckedChange(Checked As Boolean)"})
@DesignerProperties(values = {
	@Property(key="Checked", displayName="Checked", defaultValue="False", fieldType="Boolean")
})
@Version(1.21f)
public class SwitchWrapper extends ViewWrapper<Switch> implements DesignerCustomView{
	@Override
	public void DesignerCreateView(PanelWrapper base, LabelWrapper lw, Map props) {
		getObject().setChecked((Boolean)props.Get("Checked"));
		CustomViewWrapper.replaceBaseWithView2(base, getObject());
	}
	@Hide
	@Override
	public void _initialize(final BA ba, Object activityClass, String EventName) {
		final Switch _switch = new Switch(ba.context);
		final String eventName = EventName.toLowerCase(BA.cul);
		setObject(_switch);
		innerInitialize(ba, eventName, true);
		if (ba.subExists(eventName + "_checkedchange")) {
			getObject().setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					ba.raiseEventFromUI(_switch,eventName + "_checkedchange", isChecked);
				}
				
			});
		}
	}
	public boolean getChecked() {
		return getObject().isChecked();
	}
	public void setChecked(boolean Value) {
		getObject().setChecked(Value);
	}
	
}
