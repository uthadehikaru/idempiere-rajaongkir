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
/** Generated Model - DO NOT CHANGE */
package id.rekaestudigital.idempiere.rajaongkir.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for RO_Courier
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="RO_Courier")
public class X_RO_Courier extends PO implements I_RO_Courier, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20250102L;

    /** Standard Constructor */
    public X_RO_Courier (Properties ctx, int RO_Courier_ID, String trxName)
    {
      super (ctx, RO_Courier_ID, trxName);
      /** if (RO_Courier_ID == 0)
        {
			setIsInternationalCourier (false);
// N
			setIsProCourier (false);
// N
			setIsWayBillCourier (false);
// N
			setName (null);
			setRO_Courier_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RO_Courier (Properties ctx, int RO_Courier_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RO_Courier_ID, trxName, virtualColumns);
      /** if (RO_Courier_ID == 0)
        {
			setIsInternationalCourier (false);
// N
			setIsProCourier (false);
// N
			setIsWayBillCourier (false);
// N
			setName (null);
			setRO_Courier_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RO_Courier (Properties ctx, String RO_Courier_UU, String trxName)
    {
      super (ctx, RO_Courier_UU, trxName);
      /** if (RO_Courier_UU == null)
        {
			setIsInternationalCourier (false);
// N
			setIsProCourier (false);
// N
			setIsWayBillCourier (false);
// N
			setName (null);
			setRO_Courier_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RO_Courier (Properties ctx, String RO_Courier_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, RO_Courier_UU, trxName, virtualColumns);
      /** if (RO_Courier_UU == null)
        {
			setIsInternationalCourier (false);
// N
			setIsProCourier (false);
// N
			setIsWayBillCourier (false);
// N
			setName (null);
			setRO_Courier_ID (0);
        } */
    }

    /** Load Constructor */
    public X_RO_Courier (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_RO_Courier[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	/** Set Is International Courier.
		@param IsInternationalCourier Is International Courier
	*/
	public void setIsInternationalCourier (boolean IsInternationalCourier)
	{
		set_Value (COLUMNNAME_IsInternationalCourier, Boolean.valueOf(IsInternationalCourier));
	}

	/** Get Is International Courier.
		@return Is International Courier	  */
	public boolean isInternationalCourier()
	{
		Object oo = get_Value(COLUMNNAME_IsInternationalCourier);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Pro Courier.
		@param IsProCourier Courier for RajaOngkir Pro Account Type
	*/
	public void setIsProCourier (boolean IsProCourier)
	{
		set_Value (COLUMNNAME_IsProCourier, Boolean.valueOf(IsProCourier));
	}

	/** Get Is Pro Courier.
		@return Courier for RajaOngkir Pro Account Type
	  */
	public boolean isProCourier()
	{
		Object oo = get_Value(COLUMNNAME_IsProCourier);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Is Way Bill Courier.
		@param IsWayBillCourier Is Way Bill Courier
	*/
	public void setIsWayBillCourier (boolean IsWayBillCourier)
	{
		set_Value (COLUMNNAME_IsWayBillCourier, Boolean.valueOf(IsWayBillCourier));
	}

	/** Get Is Way Bill Courier.
		@return Is Way Bill Courier	  */
	public boolean isWayBillCourier()
	{
		Object oo = get_Value(COLUMNNAME_IsWayBillCourier);
		if (oo != null)
		{
			 if (oo instanceof Boolean)
				 return ((Boolean)oo).booleanValue();
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Courier.
		@param RO_Courier_ID Courier
	*/
	public void setRO_Courier_ID (int RO_Courier_ID)
	{
		if (RO_Courier_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RO_Courier_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RO_Courier_ID, Integer.valueOf(RO_Courier_ID));
	}

	/** Get Courier.
		@return Courier	  */
	public int getRO_Courier_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RO_Courier_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set RO_Courier_UU.
		@param RO_Courier_UU RO_Courier_UU
	*/
	public void setRO_Courier_UU (String RO_Courier_UU)
	{
		set_Value (COLUMNNAME_RO_Courier_UU, RO_Courier_UU);
	}

	/** Get RO_Courier_UU.
		@return RO_Courier_UU	  */
	public String getRO_Courier_UU()
	{
		return (String)get_Value(COLUMNNAME_RO_Courier_UU);
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}