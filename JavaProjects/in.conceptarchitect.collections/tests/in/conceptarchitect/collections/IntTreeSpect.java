package in.conceptarchitect.collections;

import static in.conceptarchitect.unitest.Asserts.*;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class IntTreeSpect {

	IntTree tree;
	int [] values= {15, 10, 25, 20, 5, 12,30 };
	int [] expectedInorder= {5,10,12,15,20,25,30};
	int [] expectedPreorder= {15,10,5,12,25,20,30 };
	int [] expectedPostorder= {5, 12, 10, 20, 30, 25, 15};

	static int testCount=0;
	@BeforeClass public static void resetTestCount() {testCount=0;}
	@AfterClass  
	public static void printTestCount() {
		System.out.println("Total tests executed:"+testCount);
	}

	
	
	void addValuesToTree() {
		
		for(int value:values)
			tree.add(value);
		
	}
	
	@Before
	public void setUp() throws Exception {
		testCount++;
		tree=new IntTree();
	}

	//@Ignore
	@Test
	public void binaryTreeIsACollection() {
		
		assertSubType(tree, Collection.class);
	}
	
	//@Ignore
	@Test
	public void new_binaryTreeIsEmpty() {
		
		assertTrue(tree.isEmpty());
	}
	
	

	//@Ignore
	@Test
	public void add_firstItemBecomesRoot() {
		
		
		tree.add(10);
		assertNotNull(tree.root);
		assertEquals(10,tree.root.value);
	}
	
	//@Ignore
	@Test
	public void add_lowerThanRootGoesToLeft() {
		
		//Arrange
		tree.add(10);
		
		//ACT
		tree.add(5);
		
		//Assert
		
		assertEquals(5, tree.root.left.value);
	}
	
	
	//@Ignore
	@Test
	public void add_higherThanRootGoesToRight() {
		
		//Arrange
		tree.add(10);
		
		//ACT
		tree.add(51);
		
		//Assert
		
		assertEquals(51, tree.root.right.value);
	}
	
	//@Ignore
	@Test(expected=RuleViolationException.class)
	public void add_equalToRootThrowsRuleViolationException() {
		
		//Arrange
		tree.add(10);
		
		//ACT
		tree.add(10);
		
		
	}

	@Ignore
	@Test
	public void add_allUniqueValuesAreAddedToTheTree() {
		
		addValuesToTree();
		
		assertEquals(values.length, tree.size());
		
		for(int value : values) {
			assertTrue(tree.contains(value));
		}
		
		
	}

		
	
	
	//@Ignore
	@Test()
	public void inorder_returnsAscendingOrderValues() {
		
		//Arrange
		addValuesToTree();
		
		//ACT
		System.out.println("inorder");
		tree.inOrder();
		
		//ASSERT
		fail("I don't know what to assert!");
		
		
	}
	

	//@Ignore
	@Test()
	public void preorder_returnsPreorderOrderValues() {
		
		//Arrange
		addValuesToTree();
		
		//ACT
		System.out.println("preorder");
		tree.preOrder();
		
		//ASSERT
		fail("I don't know what to assert!");
		
		
	}
	

	//@Ignore
	@Test()
	public void postorder_returnsAscendingPostorderValues() {
		
		//Arrange
		addValuesToTree();
		
		//ACT
		System.out.println("postorder");
		tree.postOrder();
		
		//ASSERT
		fail("I don't know what to assert!");
		
		
	}
	
	
	
	
	
	
	
}
