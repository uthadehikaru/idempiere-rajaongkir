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

/** Generated Model for RO_InternationalDestination
 *  @author iDempiere (generated)
 *  @version Release 13 - $Id$ */
@org.adempiere.base.Model(table="RO_InternationalDestination")
public class X_RO_InternationalDestination extends PO implements I_RO_InternationalDestination, I_Persistent
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20241231L;

    /** Standard Constructor */
    public X_RO_InternationalDestination (Properties ctx, int RO_InternationalDestination_ID, String trxName)
    {
      super (ctx, RO_InternationalDestination_ID, trxName);
      /** if (RO_InternationalDestination_ID == 0)
        {
			setName (null);
			setRO_InternationalDestination_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RO_InternationalDestination (Properties ctx, int RO_InternationalDestination_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RO_InternationalDestination_ID, trxName, virtualColumns);
      /** if (RO_InternationalDestination_ID == 0)
        {
			setName (null);
			setRO_InternationalDestination_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RO_InternationalDestination (Properties ctx, String RO_InternationalDestination_UU, String trxName)
    {
      super (ctx, RO_InternationalDestination_UU, trxName);
      /** if (RO_InternationalDestination_UU == null)
        {
			setName (null);
			setRO_InternationalDestination_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RO_InternationalDestination (Properties ctx, String RO_InternationalDestination_UU, String trxName, String ... virtualColumns)
    {
      super (ctx, RO_InternationalDestination_UU, trxName, virtualColumns);
      /** if (RO_InternationalDestination_UU == null)
        {
			setName (null);
			setRO_InternationalDestination_ID (0);
        } */
    }

    /** Load Constructor */
    public X_RO_InternationalDestination (Properties ctx, ResultSet rs, String trxName)
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
      StringBuilder sb = new StringBuilder ("X_RO_InternationalDestination[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
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

	/** Set International Destination Raja Ongkir.
		@param RO_InternationalDestination_ID International Destination Raja Ongkir
	*/
	public void setRO_InternationalDestination_ID (int RO_InternationalDestination_ID)
	{
		if (RO_InternationalDestination_ID < 1)
			set_ValueNoCheck (COLUMNNAME_RO_InternationalDestination_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_RO_InternationalDestination_ID, Integer.valueOf(RO_InternationalDestination_ID));
	}

	/** Get International Destination Raja Ongkir.
		@return International Destination Raja Ongkir	  */
	public int getRO_InternationalDestination_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_RO_InternationalDestination_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set RO_InternationalDestination_UU.
		@param RO_InternationalDestination_UU RO_InternationalDestination_UU
	*/
	public void setRO_InternationalDestination_UU (String RO_InternationalDestination_UU)
	{
		set_Value (COLUMNNAME_RO_InternationalDestination_UU, RO_InternationalDestination_UU);
	}

	/** Get RO_InternationalDestination_UU.
		@return RO_InternationalDestination_UU	  */
	public String getRO_InternationalDestination_UU()
	{
		return (String)get_Value(COLUMNNAME_RO_InternationalDestination_UU);
	}
}