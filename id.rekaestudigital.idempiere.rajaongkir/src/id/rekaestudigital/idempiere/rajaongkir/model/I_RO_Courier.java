/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package id.rekaestudigital.idempiere.rajaongkir.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for RO_Courier
 *  @author iDempiere (generated) 
 *  @version Release 13
 */
@SuppressWarnings("all")
public interface I_RO_Courier 
{

    /** TableName=RO_Courier */
    public static final String Table_Name = "RO_Courier";

    /** AD_Table_ID=1000006 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 7 - System - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(7);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Tenant.
	  * Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within tenant
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within tenant
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsInternationalCourier */
    public static final String COLUMNNAME_IsInternationalCourier = "IsInternationalCourier";

	/** Set Is International Courier	  */
	public void setIsInternationalCourier (boolean IsInternationalCourier);

	/** Get Is International Courier	  */
	public boolean isInternationalCourier();

    /** Column name IsProCourier */
    public static final String COLUMNNAME_IsProCourier = "IsProCourier";

	/** Set Is Pro Courier.
	  * Courier for RajaOngkir Pro Account Type
	  */
	public void setIsProCourier (boolean IsProCourier);

	/** Get Is Pro Courier.
	  * Courier for RajaOngkir Pro Account Type
	  */
	public boolean isProCourier();

    /** Column name IsWayBillCourier */
    public static final String COLUMNNAME_IsWayBillCourier = "IsWayBillCourier";

	/** Set Is Way Bill Courier	  */
	public void setIsWayBillCourier (boolean IsWayBillCourier);

	/** Get Is Way Bill Courier	  */
	public boolean isWayBillCourier();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name RO_Courier_ID */
    public static final String COLUMNNAME_RO_Courier_ID = "RO_Courier_ID";

	/** Set Courier	  */
	public void setRO_Courier_ID (int RO_Courier_ID);

	/** Get Courier	  */
	public int getRO_Courier_ID();

    /** Column name RO_Courier_UU */
    public static final String COLUMNNAME_RO_Courier_UU = "RO_Courier_UU";

	/** Set RO_Courier_UU	  */
	public void setRO_Courier_UU (String RO_Courier_UU);

	/** Get RO_Courier_UU	  */
	public String getRO_Courier_UU();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name Value */
    public static final String COLUMNNAME_Value = "Value";

	/** Set Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value);

	/** Get Search Key.
	  * Search key for the record in the format required - must be unique
	  */
	public String getValue();
}
