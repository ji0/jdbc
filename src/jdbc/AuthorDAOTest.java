package jdbc;

import java.sql.SQLException;
import java.util.List;

import sds.icto.dao.AuthorDAO;
import sds.icto.vo.AuthorVO;

public class AuthorDAOTest {

	public static void main(String[] args) {

		// insertTest();

		try {
			selectTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertTest() throws ClassNotFoundException, SQLException {
		AuthorDAO dao = new AuthorDAO();

		// 1 VO 하나생성
		AuthorVO vo = new AuthorVO();
		vo.setName("장자");
		vo.setBio("");
		dao.insert(vo);

		AuthorVO vo2 = new AuthorVO();
		vo2.setName("순자");
		vo2.setBio("");
		dao.insert(vo2);

	}

	public static void selectTest() throws ClassNotFoundException, SQLException {

		AuthorDAO dao = new AuthorDAO();
		List<AuthorVO> list = dao.fetch();

		for (AuthorVO vo : list) {

			System.out.println(vo.getId() + " : " + vo.getName() + " : "
					+ vo.getBio());

		}
	}

}
