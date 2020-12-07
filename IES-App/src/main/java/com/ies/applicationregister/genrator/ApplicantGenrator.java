package com.ies.applicationregister.genrator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ApplicantGenrator implements IdentifierGenerator{
	private final String prefix ="IES";
	private final String GET_SQL_SEQUENCE = "select APPICANTSEQ.nextval from dual";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String suffix = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = session.connection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(GET_SQL_SEQUENCE);
			if (rs.next()) {
				int seqVal = rs.getInt(1);
				suffix = String.valueOf(seqVal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefix + suffix;
	}

}



