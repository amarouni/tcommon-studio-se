/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.designer.core.model.utils.emf.talendfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.talend.designer.core.model.AbstractElementParameter;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.ParametersType;
import org.talend.designer.core.model.utils.emf.talendfile.TalendFilePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Parameters Type</b></em>'.
 * 
 * @extend AbstractElementParameter <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.talend.designer.core.model.utils.emf.talendfile.impl.ParametersTypeImpl#getElementParameter <em>
 * Element Parameter</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ParametersTypeImpl extends AbstractElementParameter implements ParametersType {

    /**
     * The cached value of the '{@link #getElementParameter() <em>Element Parameter</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElementParameter()
     * @generated
     * @ordered
     */
    protected EList elementParameter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ParametersTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EClass eStaticClass() {
        return TalendFilePackage.Literals.PARAMETERS_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList getElementParameter() {
        if (elementParameter == null) {
            elementParameter = new EObjectContainmentEList(ElementParameterType.class, this,
                    TalendFilePackage.PARAMETERS_TYPE__ELEMENT_PARAMETER);
        }
        return elementParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case TalendFilePackage.PARAMETERS_TYPE__ELEMENT_PARAMETER:
            return ((InternalEList) getElementParameter()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case TalendFilePackage.PARAMETERS_TYPE__ELEMENT_PARAMETER:
            return getElementParameter();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case TalendFilePackage.PARAMETERS_TYPE__ELEMENT_PARAMETER:
            getElementParameter().clear();
            getElementParameter().addAll((Collection) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void eUnset(int featureID) {
        switch (featureID) {
        case TalendFilePackage.PARAMETERS_TYPE__ELEMENT_PARAMETER:
            getElementParameter().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case TalendFilePackage.PARAMETERS_TYPE__ELEMENT_PARAMETER:
            return elementParameter != null && !elementParameter.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // ParametersTypeImpl
