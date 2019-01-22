// Copyright (c) 2002 Cunningham & Cunningham, Inc.
// Released under the terms of the GNU General Public License version 2 or later.

package fit;

import java.util.Date;
import java.text.*;

public class TimedActionFixture extends ActionFixture {

    public DateFormat format = new SimpleDateFormat("hh:mm:ss");

    // Traversal ////////////////////////////////

    public void doTable(Parse table) {
        super.doTable(table);
        table.parts.parts.last().more = td("time");
        table.parts.parts.last().more = td("split");
    }

    public void doCells(Parse cells) {
        Date start  = time();
        super.doCells(cells);
        long split = time().getTime() - start.getTime();
        cells.last().more = td(format.format(start));
        cells.last().more = td(split<1000 ? "&nbsp;" : Double.toString((split)/1000.0));
    }

    // Utility //////////////////////////////////

    public Date time() {
        return new Date();
    }

    public Parse td (String body) {
        return new Parse("td", info(body), null, null);
    }

}
