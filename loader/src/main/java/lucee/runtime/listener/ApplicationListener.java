/**
 * Copyright (c) 2014, the Railo Company Ltd.
 * Copyright (c) 2015, Lucee Association Switzerland
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
 */
package lucee.runtime.listener;

import lucee.runtime.CFMLFactory;
import lucee.runtime.PageContext;
import lucee.runtime.PageSource;
import lucee.runtime.exp.PageException;

/**
 * interface for PageContext to interact with CFML
 * 
 */
public interface ApplicationListener {

	public static final int MODE_CURRENT2ROOT = 0;
	public static final int MODE_CURRENT = 1;
	public static final int MODE_ROOT = 2;
	public static final int MODE_CURRENT_OR_ROOT = 4;

	public static final int TYPE_NONE = 0;
	public static final int TYPE_CLASSIC = 1;
	public static final int TYPE_MODERN = 2;
	public static final int TYPE_MIXED = 4;

	public static final String CFC_EXTENSION = "cfc";

	public void setMode(int mode);

	public int getMode();

	/**
	 * @return the type
	 */
	public String getType();

	/**
	 * this method will be called the Application self
	 * 
	 * @param pc Page Context
	 * @param requestedPage Requested Page
	 * @param rl Request Listener
	 * @throws PageException Page Exception
	 */
	public void onRequest(PageContext pc, PageSource requestedPage, RequestListener rl) throws PageException;

	/**
	 * this method will be called when a new Session starts
	 * 
	 * @param pc Page Context
	 * @throws PageException Page Exception
	 */
	public void onSessionStart(PageContext pc) throws PageException;

	/**
	 * this method will be called when a Session ends
	 * 
	 * @param cfmlFactory CFML Factory
	 * @param applicationName Application Name
	 * @param cfid cfid
	 * @throws PageException Page Exception
	 */
	public void onSessionEnd(CFMLFactory cfmlFactory, String applicationName, String cfid) throws PageException;

	/**
	 * this method will be called when a new Application Context starts
	 * 
	 * @param pc Page Context
	 * @return success or failure
	 * @throws PageException Page Exception
	 */
	public boolean onApplicationStart(PageContext pc) throws PageException;

	/**
	 * this method will be called when an Application scope ends
	 *
	 * @param cfmlFactory CFML Factory
	 * @param applicationName Application Name
	 * @throws PageException Page Exception
	 */
	public void onApplicationEnd(CFMLFactory cfmlFactory, String applicationName) throws PageException;

	/**
	 * this method will be called when a Server starts
	 * 
	 * @throws PageException Page Exception
	 */
	public void onServerStart() throws PageException;

	/**
	 * this method will be called when the Server shutdown correctly (no crashes)
	 * 
	 * @throws PageException Page Exception
	 */
	public void onServerEnd() throws PageException;

	/**
	 * this method will be called if Server has an error (exception) not thrown by a try-catch block
	 * 
	 * @param pc Page Context
	 * @param pe PageException Exception that has been thrown
	 */
	public void onError(PageContext pc, PageException pe);

	/**
	 * called after "onRequestEnd" to generate debugging output, will only be called when debugging is
	 * enabled
	 * 
	 * @param pc Page Context
	 * @throws PageException Page Exception
	 */
	public void onDebug(PageContext pc) throws PageException;

	/**
	 * will be called when the Server runs into a timeout
	 * 
	 * @param pc Page Context
	 */
	public void onTimeout(PageContext pc);

	public boolean hasOnApplicationStart();

	public boolean hasOnSessionStart(PageContext pc);
}
