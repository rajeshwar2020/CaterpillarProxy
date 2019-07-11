import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Test;

import com.rajesh.model.Student;

public class MultiLevelCacheTest {
	private static Configuration c = new Configuration();

	@SuppressWarnings("deprecation")
	private static final SessionFactory sf = c.buildSessionFactory();

	@Test
	public void testFirstLevelCache() {
		c.configure("/hibernate.cfg.xml");

		Session s1 = sf.openSession();
		Session s2 = sf.openSession();

		Student std1 = (Student) s1.get(Student.class, new Integer(1));
		Assert.assertEquals(std1.getId(), 1);
		Assert.assertEquals(std1.getMarks(), 100.00);
		Assert.assertEquals(std1.getName(), "student1");

		Student std2 = (Student) s2.get(Student.class, new Integer(2));
		Assert.assertEquals(std1.getId(), 2);
		Assert.assertEquals(std1.getMarks(), 200.00);
		Assert.assertEquals(std1.getName(), "student2");
	}

	@Test
	public void testSecondLevelCache() {
		// second level cached is configured in config file below (hibernate.cfg.xml)
		c.configure("/hibernate.cfg.xml");

		Session s1 = sf.openSession();
		Session s2 = sf.openSession();

		try {
			// As i don't have a DB setup Assuming and testing for the multi Level Cache 
			Student std1 = (Student) s1.get(Student.class, new Integer(1));
			Assert.assertEquals(std1.getId(), 1);
			Assert.assertEquals(std1.getMarks(), 100.00);
			Assert.assertEquals(std1.getName(), "student1");

			Student std2 = (Student) s2.get(Student.class, new Integer(2));
			Assert.assertEquals(std1.getId(), 2);
			Assert.assertEquals(std1.getMarks(), 200.00);
			Assert.assertEquals(std1.getName(), "student2");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
