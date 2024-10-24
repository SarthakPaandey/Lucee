/**
 *
 * Copyright (c) 2014, the Railo Company Ltd. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either 
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with this library.  If not, see <http://www.gnu.org/licenses/>.
 * 
 **/
package lucee.runtime.functions.dateTime;

import lucee.runtime.PageContext;
import lucee.runtime.exp.ExpressionException;
import lucee.runtime.exp.PageException;
import lucee.runtime.ext.function.BIF;
import lucee.runtime.op.Caster;
import lucee.runtime.type.dt.DateTime;

public class DateAddMember extends BIF {

	private static final long serialVersionUID = 2435230088985760512L;

	public static DateTime call(PageContext pc, DateTime date, String datepart, Number number) throws ExpressionException {
		return DateAdd.call(pc, datepart, number, date);
	}

	public static DateTime call(PageContext pc, DateTime date, String datepart, double number) throws ExpressionException {
		return DateAdd.call(pc, datepart, number, date);
	}

	@Override
	public Object invoke(PageContext pc, Object[] args) throws PageException {
		return call(pc, Caster.toDatetime(args[0], pc.getTimeZone()), Caster.toString(args[1]), Caster.toNumber(pc, args[2]));
	}
}