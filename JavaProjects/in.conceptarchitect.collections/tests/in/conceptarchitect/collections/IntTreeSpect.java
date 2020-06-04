package in.conceptarchitect.collections;

import static in.conceptarchitect.unitest.Asserts.*;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.helpers.AverageFinder;

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

	//@Ignore
	@Test
	public void add_allUniqueValuesAreAddedToTheTree() {
		
		addValuesToTree();
		
		int x; //non-final value type cant be used inside  anonymous class or lambda
		
		
		final int []count= {0}; //hack: create an array (object) and have value
		
		tree.inOrder(v-> count[0]++);
		
		assertEquals(values.length, count[0]);
		
	}
	
	@Test
	public void inorder_canCoutItemsOfTheList() {
		
		addValuesToTree();
		
		
		Counter counter=new Counter();
		
		//signature mismatch. increment takes no argument
		//Action interface takes 1 argument
		//tree.inOrder(counter::increment);
		
		tree.inOrder(v-> counter.increment());
		
		assertEquals(values.length, counter.getValue());
		
	}

		
	
	
	//@Ignore
	@Test()
	public void inorder_returnsAscendingOrderValues() {
		
		//Arrange
		addValuesToTree();
		ListBuilderAction<Integer> builder=new ListBuilderAction<Integer>();
		
		//ACT
		LinkedList<Integer> results= tree.inOrder(builder);
		
		//LinkedList<Integer> results=builder.getResult();
		
		//ASSERT
		assertRightSequence(results, expectedInorder);
		
		
	}
	private void assertRightSequence(LinkedList<Integer> actual, int... expected) {
		for(int i=0;i<expected.length;i++) {
			assertIntEquals(expected[i], actual.get(i));
		}
	}
	

	//@Ignore
	@Test()
	public void preorder_returnsPreorderOrderValues() {
		
		//Arrange
		addValuesToTree();
		
		LinkedList<Integer> results=new LinkedList<Integer>();
		
		//ACT
		tree.preOrder(value-> results.add(value));
		
		
		//ASSERT
		assertRightSequence(results, expectedPreorder);
		
		
	}
	

	//@Ignore
	@Test()
	public void postorder_returnsAscendingPostorderValues() {
		
		//Arrange
		addValuesToTree();
		
		LinkedList<Integer> results=new LinkedList<Integer>();
		
		
		//ACT
		//tree.postOrder(value->results.add(value));
		tree.postOrder(results::add);
		
		
		//ASSERT
		assertRightSequence(results, expectedPostorder);
		
		
	}
	
	
	@Test
	public void main_printValuesInorderPreOrderPostOrder() {
		
		addValuesToTree();
		
		System.out.println("inorder");
		tree.inOrder(value-> System.out.println(value));
		
		System.out.println("preorder");
		tree.preOrder(value-> System.out.print(value+"\t"));
		
		
		System.out.println("\npostorder");
		tree.postOrder(value-> System.out.println(value));
		
	}
	
	
	@Test
	public void preorder_canCalculateAverage() {
		
		AverageFinder<Integer> calc=new AverageFinder<Integer>();
		
		addValuesToTree();
		
		double average= tree.preOrder(calc);
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		tree.preOrder(list::add); //get all value in a list
		
		
		//action can be applied to list also
		double listAverage= list.each(calc);
		
		assertEquals(listAverage, average, 0.01);
		
		
		
		
	}
	
	@Test
	public void iterate_treeElementsCanBeIterated() {
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		for(int value: tree) {
			list.add(value);
		}
		
		assertEquals(tree.size(), list.size());

		//list should by default loop preorder
		assertRightSequence(list, expectedPreorder);
	}
	
	
	
	
	
	
}
