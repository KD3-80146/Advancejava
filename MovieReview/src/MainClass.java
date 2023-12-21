import com.sunbeam.dao.MovieDaoImpl;
import com.sunbeam.dao.ReviewDaoImpl;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.User;

/*
public class MainClass {

	public static void main(String[] args) {
		try(UserDaoImpl uDao=new UserDaoImpl())
		{
			User u=new User(0,"adnan","khan","amkadnan89@gmail.com","adnan","8770151532","2000-10-05");
			int count=uDao.save(u);
			System.out.println("Data saved:"+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
*/

//public class MainClass {
//
//	public static void main(String[] args) {
//		try(UserDaoImpl uDao=new UserDaoImpl())
//		{
//			User u=new User(5,"adnan","khan","amkadnan89@gmail.com","adnan","8770151532","05-10-2000");
//			int count=uDao.update(u);
//			System.out.println("Data update:"+count);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}


//public class MainClass {
//
//	public static void main(String[] args) {
//		try(UserDaoImpl uDao=new UserDaoImpl())
//		{
//			int count=uDao.updatePassword(4, "1234onkar");
//			if(count==1)
//			{
//				System.out.println("Password Updated");
//			}
//			else
//			{
//				System.out.println("Something happend wrong");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}



//public class MainClass {
//
//	public static void main(String[] args) {
//		try(UserDaoImpl uDao=new UserDaoImpl())
//		{
//			
//			System.out.println(uDao.findByEmail("amkadnan89@gmail.com"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}

//public class MainClass {
//
//	public static void main(String[] args) {
//		try(UserDaoImpl uDao=new UserDaoImpl())
//		{
//			uDao.findAll().forEach(e->System.out.println(e.toString()));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}



//public class MainClass {
//	public static void main(String[] args) {
//		try(MovieDaoImpl mDao=new MovieDaoImpl())
//		{
//			mDao.findAll().forEach(e->System.out.println(e.toString()));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}

//public class MainClass {
//public static void main(String[] args) {
//	try(MovieDaoImpl mDao=new MovieDaoImpl())
//	{
//		System.out.println(mDao.findById(5).toString());;
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//
//}


//public class MainClass {
//public static void main(String[] args) {
//	try(ReviewDaoImpl rDao=new ReviewDaoImpl())
//	{
//		Review r=new Review(0,2,"dumb movie",8,2,null);
//		System.out.println("Review Added:"+rDao.save(r));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//}

//public class MainClass {
//public static void main(String[] args) {
//	try(ReviewDaoImpl rDao=new ReviewDaoImpl())
//	{
//		Review r=new Review(13,2,"bad movie",8,2,null);
//		System.out.println("Review Added:"+rDao.update(r));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//}

//public class MainClass {
//public static void main(String[] args) {
//	try(ReviewDaoImpl rDao=new ReviewDaoImpl())
//	{
//		rDao.findAll().forEach(e->System.out.println(e.toString()));
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//}



/*public class MainClass {
public static void main(String[] args) {
	try(ReviewDaoImpl rDao=new ReviewDaoImpl())
	{
		rDao.findByUserId(4).forEach(e->System.out.println(e));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}*/


/*public class MainClass {
	public static void main(String[] args) {
		try(ReviewDaoImpl rDao=new ReviewDaoImpl())
		{
			rDao.getSharedWithUser(4).forEach(e->System.out.println(e.toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
*/
/*
public class MainClass {
	public static void main(String[] args) {
		try(ReviewDaoImpl rDao=new ReviewDaoImpl())
		{
			System.out.println(rDao.findById(10).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}*/

/*public class MainClass {
	public static void main(String[] args) {
		try(ReviewDaoImpl rDao=new ReviewDaoImpl())
		{
			System.out.println("Deleted :"+rDao.deleteById(12));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}*/
//public class MainClass {
//	public static void main(String[] args) {
//		try(ReviewDaoImpl rDao=new ReviewDaoImpl())
//		{
//			rDao.shareReview(11, 4);
//			rDao.shareReview(13, 4);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}

