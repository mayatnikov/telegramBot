/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mvn.tgBot.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.*;

public class RegexTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testEmailChecker() throws Exception {
//		mvn.tgBot.Application.main(new String[0]);

		String in="aaa@vvv.com";
		assertTrue("Wrong check: " + in, Regexp.checkEmail(in));
		in="mayatnikov@gmail.com";
		assertTrue("Wrong check: " + in, Regexp.checkEmail(in));
		in="mayatnikov@aaa.mail.zzzz.com";
		assertTrue("Wrong check: " + in, Regexp.checkEmail(in));
		in="gmail.com";
		assertFalse("Wrong check: " + in, Regexp.checkEmail(in));
		in="aaaa.gmail.com";
		assertFalse("Wrong check: " + in, Regexp.checkEmail(in));

	}

	@Test
	public void testFilterUserData() throws Exception {
		String[] in = {
				"PETROV PETR 12/12/12 987876567",
				"  PETROV PETR 12/12/12 98 7876567",
				"    PETROV      PETR 12/12/12 987876567",
				"    PETROV PETR 12/12/12 987876567",
				"  PETROV       PETR            12/12/12            987876567",
				"         PETROV        PETR         12/12/12             987876567",};
		String[] mustBe = {"PETROV","PETR","12/12/12","987876567"};

		for(int tt=0; tt< in.length; tt++) {
			String[] out =Regexp.filterUserData(in[tt]);
			assertArrayEquals( out,mustBe );
		}
	}

	@Test
	public void testDate() throws Exception {
		String in1[] = {"11-11-96","6-1-1998","06.01.1998","06-01","12/08/1999","14 06 2017","12/05/16","14 06 2015","0304","1201","7", "21","121"};

		String in;
		String mustBe;
		String out;

		in= "11-11-96";
		mustBe="11/11/1996";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );

		in= "6/1/1998";
		mustBe="06/01/1998";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );

		in= "6-1-1998";
		mustBe="06/01/1998";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );

		in= "06.01.1998";
		mustBe="06/01/1998";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );
		in= "06-01";
		mustBe="06/01/2016";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );
		in= "12/08/1999";
		mustBe="12/08/1999";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );
		in= "14 06 2017";
		mustBe="14/06/2017";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );
		in= "12/05/16";
		mustBe="12/05/2016";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );
		in= "14 06 2016";
		mustBe="14/06/2016";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );
		in= "12,5,16";
		mustBe="12/05/2016";
		out = Regexp.filterDate(in);
		assertEquals("Bad convertion in:"+in+" to:"+out, out,mustBe );

	}
}
/*
    public static void main (String ... args ) {
        Regexp re = new Regexp();
        String in1[] = {"11-11-96","6-1-1998","06.01.1998","06-01","12/08/1999","14 06 2017","12/05/16","14 06 2015","0304","1201","7", "21","121"};
        for(int tik=0;tik< in1.length;tik++) {
            System.out.println(">>>>> "+in1[tik]);
            try {
                String res = re.filterDate(in1[tik]);
                System.out.println("<<<<<< "+res);
                System.out.println();
            } catch ( java.time.DateTimeException e) {
                System.out.println("=====>"+ e.getMessage());
            }
        }
    }

 */