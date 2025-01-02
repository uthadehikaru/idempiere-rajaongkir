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

/** Generated Model for RO_Subdistrict
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="RO_Subdistrict")
public class X_RO_Subdistrict extends PO implements I_RO_Subdistrict, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241230L;

    /** Standard Constructor */
    public X_RO_Subdistrict (Properties ctx, int RO_Subdistrict_ID, String trxName)
    {
      super (ctx, RO_Subdistrict_ID, trxName);
      /** if (RO_Subdistrict_ID == 0)
        {
			setName (null);
			setRO_Subdistrict_ID (0);
			setRO_Subdistrict_Type (null);
        } */
    }

    /** Standard Constructor */
    public X_RO_Subdistrict (Properties ctx, int RO_Subdistrict_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RO_Subdistrict_ID, trxName, virtualColumns);
      /** if (RO_Subdistrict_ID == 0)
        {
			setName (null);
			setRO_Subdistrict_ID (0);
			setRO_Subdistrict_Type (null);
        } */
    }

    /** Standard Constructor */
    public X_RO_Subdistrict (Properties ctx, String RO_Subdistrict_UU, String trxName)
    {
      super (ctx, RO_Subdistrict_UU, trxName);
      /** if (RO_Subdistrict_UU == null)
        {
			setName (null);
			setRO_Subdistrict_ID (0);
			setRO_Subdistrict_Type (null);
        } */
    }

    /** Standard Constructor */
    public X_RO_Subdistrict (Properties ctx, String RO_Subdistrict_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, RO_Subdistrict_UU, trxName, virtualColumns);
      /** if (RO_Subdistrict_UU == null)
        {
			setName (null);
			setRO_Subdistrict_ID (0);
			setRO_Subdistrict_Type (null);
        } */
    }

    /** Load Constructor */
    public X_RO_Subdistrict (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 6 - System - Client
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
      StringBuilder sb = new StringBuilder ("X_RO_Subdistrict[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_City getC_City() throws RuntimeException
	{
		return (org.compiere.model.I_C_City)MTable.get(getCtx(), org.compiere.model.I_C_City.Table_ID)
			.getPO(getC_City_ID(), get_TrxName());
	}

	/** Set City.
		@param C_City_ID City
	*/
	public void setC_City_ID (int C_City_ID)
	{
		if (C_City_ID < 1)
			set_ValueNoCheck (COLUMNNAME_C_City_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_C_City_ID, Integer.valueOf(C_City_ID));
	}

	/** Get City.
		@return City
	  */
	public int getC_City_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_City_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Subdistrict.
		@param RO_Subdistrict_ID Subdistrict
	*/
	public void setRO_Subdistrict_ID (int RO_Subdistrict_ID)
	{
		if (RO_Subdistrict_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RO_Subdistrict_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RO_Subdistrict_ID, Integer.valueOf(RO_Subdistrict_ID));
	}

	/** Get Subdistrict.
		@return Subdistrict	  */
	public int getRO_Subdistrict_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RO_Subdistrict_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Subdistrict Type.
		@param RO_Subdistrict_Type Subdistrict Type
	*/
	public void setRO_Subdistrict_Type (String RO_Subdistrict_Type)
	{
		set_Value (COLUMNNAME_RO_Subdistrict_Type, RO_Subdistrict_Type);
	}

	/** Get Subdistrict Type.
		@return Subdistrict Type	  */
	public String getRO_Subdistrict_Type()
	{
		return (String)get_Value(COLUMNNAME_RO_Subdistrict_Type);
	}

	/** Set RO_Subdistrict_UU.
		@param RO_Subdistrict_UU RO_Subdistrict_UU
	*/
	public void setRO_Subdistrict_UU (String RO_Subdistrict_UU)
	{
		set_Value (COLUMNNAME_RO_Subdistrict_UU, RO_Subdistrict_UU);
	}

	/** Get RO_Subdistrict_UU.
		@return RO_Subdistrict_UU	  */
	public String getRO_Subdistrict_UU()
	{
		return (String)get_Value(COLUMNNAME_RO_Subdistrict_UU);
	}
}