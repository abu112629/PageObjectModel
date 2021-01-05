package com.canadalife.automation.grsoe.components;

import com.canadalife.automation.grsoe.support.AppHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.testng.TestNGBase;
import ui.auto.core.utils.WebHelper;

import java.util.ArrayList;
import java.util.List;

public class PlanRadioGroup extends WebComponentList {

    private void init() {
        super.initPage(TestNGBase.CONTEXT());
    }

    @Override
    public void validateAll() {
        init();
        super.validateAll();
    }

    @Override
    public void validateUnordered() {
        init();
        super.validateUnordered();
    }

    public String getSelected() {
        init();
        for (String key : getElementsMap().keySet()) {
            if (getElementsMap().get(key).findElement(By.xpath(".//input")).isSelected()) {
                return key.split("\n")[0];
            }
        }
        return null;
    }

    public String getToSelect() {
        for (WebComponent comp : this.getData()) {
            String value = comp.getData(DataTypes.Expected);
            if (value != null && value.equals("select")) {
                return comp.getData().trim().split("\n")[0];
            }
        }
        return null;
    }

    @Step("Select \"{0}\" plan")
    public void select(String value) {
        init();
        for (String key : getElementsMap().keySet()) {
            if (key.toLowerCase().split("\n")[0].equals(value.toLowerCase())) {
                WebElement el = getElementsMap().get(key);
                AppHelper.scrollToView(el);
                el.click();
                return;
            }
        }
        throw new RuntimeException("Option \"" + value + "\" is not available for given radio group component");
    }

    public List<String> getElements() {
        init();
        List<String> values = new ArrayList<>();
        getElementsMap().keySet().forEach((key)->values.add(key.split("\n")[0]));
        return values;
    }

    @Step("Validate that \"{0}\" plan is selected")
    public void isSelected(String value) {
        init();
        Assertions.assertThat(getSelected()).isEqualTo(value);
        List<WebElement> selectedElements = getDriver().findElements(By.xpath("//span[contains(@class,'nds-card-selected ')]"));
        Assertions.assertThat(selectedElements).hasSize(1);
        List<WebElement> notSelected = getDriver().findElements(By.xpath("//span[contains(@class,'nds-card-select ')]"));
        Assertions.assertThat(notSelected).hasSize(5);
    }

}
