/*
 * Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
 * Haulmont Technology proprietary and confidential.
 * Use is subject to license terms.
 */

package com.haulmont.cuba.web.gui.components;

import com.haulmont.cuba.gui.components.ProgressBar;
import com.vaadin.ui.ProgressIndicator;

/**
 * Web realization of progress bar depending on vaadin {@link ProgressIndicator} component.
 * <p/>
 * Note that indeterminate bar implemented here just like as determinate, but with fixed 0.0 value
 * <p/>
 *
 * @author Alexander Budarov
 * @version $Id$
 */
public class WebProgressBar extends WebAbstractField<ProgressIndicator> implements ProgressBar {
    protected boolean indeterminate;

    public WebProgressBar() {
        component = new ProgressIndicator();
        attachListener(component);
        component.setImmediate(true);
        component.setInvalidCommitted(true);
        component.setIndeterminate(false);
        // disable polling on client
        component.setPollingInterval(Integer.MAX_VALUE);
    }

    @Override
    public boolean isIndeterminate() {
        return component.isIndeterminate();
    }

    @Override
    public void setIndeterminate(boolean indeterminate) {
        if (this.indeterminate != indeterminate)
            component.setIndeterminate(indeterminate);

        if (indeterminate) {
            component.setValue(0.0f);
        }
    }
}