/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////
// Title: P4 Package Manager
// Files: GraphTest.java
// Semester: Spring 2019
// Course: CS400
// Lecture: 002
// Due Date: Before 10pm on March 16, 2019
// Author: Shiyu Zhu
// Email: SZHU227@wisc.edu
// Lecture's Name: Deb Deppeler
// Bugs: no known bugs
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Yujie Wang
// Partner Email: ywang2327@wisc.edu
// Partner Lecturer's Name: Deb Deppeler
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import static org.junit.jupiter.api.Assertions.*; // org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

/**
 * 
 * This is the class which test all implementations in the Directed and unweighted graph
 */
public class GraphTest {

  /**
   * Test whether the graph returns correct order after add and remove some vertex.
   */
  @Test
  public void test001_addVertex_removeVertex_order() {
    Graph testGraph001 = new Graph();
    testGraph001.addVertex("A");
    testGraph001.addVertex("B");
    testGraph001.addVertex("C");
    testGraph001.addVertex("D");
    testGraph001.addVertex("E");
    testGraph001.addVertex("F");
    testGraph001.removeVertex("E");
    int orderResult = testGraph001.order();
    if (orderResult != 5) {
      fail("The order of the graph should be 5, but the result is " + orderResult);
    }
  }

  /**
   * Test whether the graph returns correct size after add and remove some edges.
   */
  @Test
  public void test002_addEdge_removeEdge_size() {
    Graph testGraph002 = new Graph();
    testGraph002.addVertex("A");
    testGraph002.addVertex("B");
    testGraph002.addVertex("C");
    testGraph002.addVertex("D");
    testGraph002.addVertex("E");
    testGraph002.addEdge("A", "B");
    testGraph002.addEdge("A", "E");
    testGraph002.addEdge("B", "E");
    testGraph002.addEdge("B", "C");
    testGraph002.addEdge("C", "B");
    testGraph002.addEdge("D", "C");
    testGraph002.addEdge("D", "E");
    testGraph002.addEdge("E", "D");
    testGraph002.removeEdge("C", "B");
    int sizeResult = testGraph002.size();
    if (sizeResult != 7) {
      fail("The size of the graph should be 7, but the result is " + sizeResult);
    }
  }

  /**
   * Test whether the graph returns correct set of vertex after add and remove some vertex.
   */
  @Test
  public void test003_addVertex_removeVertex_getAllVertices() {
    Graph testGraph003 = new Graph();
    testGraph003.addVertex("A");
    testGraph003.addVertex("B");
    testGraph003.addVertex("C");
    testGraph003.addVertex("D");
    testGraph003.addVertex("E");
    testGraph003.addVertex("F");
    testGraph003.removeVertex("F");
    ArrayList<String> arr = new ArrayList<String>();
    arr.add("A");
    arr.add("B");
    arr.add("C");
    arr.add("D");
    arr.add("E");
    Set<String> allVertivalExpected = new HashSet<String>(arr);
    Set<String> allVertivalResult = testGraph003.getAllVertices();
    // Checking for every element in expected set
    for (final String element : allVertivalExpected) {
      // if result set has the current element
      if (!allVertivalResult.contains(element)) {
        fail("The expected set of vertex of the graph should be " + allVertivalExpected
            + " , but the result is " + allVertivalResult);
      }
    }
  }

  
  /**
   * Test whether the graph returns correct order after add null vertex.
   */
  @Test
  public void test004_addNullVertex() {
    Graph testGraph004 = new Graph();
    testGraph004.addVertex("A");
    testGraph004.addVertex("B");
    testGraph004.addVertex("C");
    testGraph004.addVertex("D");
    testGraph004.addVertex("E");
    testGraph004.addVertex(null);
    int orderResult = testGraph004.order();
    if (orderResult != 5) {
      fail("The order of the graph should be 5, but the result is " + orderResult);
    }
  }

  /**
   * Test whether the graph returns correct order after add some vertex and then remove NULL.
   */
  @Test
  public void test005_addVertex_removeNullVertex() {
    Graph testGraph005 = new Graph();
    testGraph005.addVertex("A");
    testGraph005.addVertex("B");
    testGraph005.addVertex("C");
    testGraph005.addVertex("D");
    testGraph005.addVertex("E");
    testGraph005.removeVertex(null);
    int orderResult = testGraph005.order();
    if (orderResult != 5) {
      fail("The order of the graph should be 5, but the result is " + orderResult);
    }
  }

  /**
   * Test whether the graph returns correct order after add vertex that already contained.
   */
  @Test
  public void test006_addContainedVertex() {
    Graph testGraph006 = new Graph();
    testGraph006.addVertex("A");
    testGraph006.addVertex("B");
    testGraph006.addVertex("C");
    testGraph006.addVertex("D");
    testGraph006.addVertex("E");
    testGraph006.addVertex("E");
    int orderResult = testGraph006.order();
    if (orderResult != 5) {
      fail("The order of the graph should be 5, but the result is " + orderResult);
    }
  }

  /**
   * Test whether the graph returns correct order after add some vertex and then remove the node
   * that not contained in the graph.
   */
  @Test
  public void test007_addVertex_removeNotContainedVertex() {
    Graph testGraph007 = new Graph();
    testGraph007.addVertex("A");
    testGraph007.addVertex("B");
    testGraph007.addVertex("C");
    testGraph007.addVertex("D");
    testGraph007.addVertex("E");
    testGraph007.removeVertex("F");
    int orderResult = testGraph007.order();
    if (orderResult != 5) {
      fail("The order of the graph should be 5, but the result is " + orderResult);
    }
  }

  /**
   * Test whether the graph returns correct size and order after add both vertex not exits
   */
  @Test
  public void test008_addEdgeWithBothVertexNotExist() {
    Graph testGraph008 = new Graph();
    testGraph008.addVertex("A");
    testGraph008.addVertex("B");
    testGraph008.addVertex("C");
    // without vertex "D","E"
    testGraph008.addEdge("A", "B");
    testGraph008.addEdge("A", "E");
    testGraph008.addEdge("B", "E");
    testGraph008.addEdge("B", "C");
    testGraph008.addEdge("C", "B");
    testGraph008.addEdge("D", "C");
    testGraph008.addEdge("D", "E");
    testGraph008.addEdge("E", "D");
    testGraph008.removeEdge("C", "B");
    int sizeResult = testGraph008.size();
    int orderResult = testGraph008.order();
    if (sizeResult != 7 && orderResult != 5) {
      fail("The size of the graph should be 7, but the result is " + sizeResult
          + "The order of the graph should be 5, but the result is " + orderResult);
    }
  }

  /**
   * Test whether the graph returns correct size and order after remove edge when both vertices are
   * both in the graph
   */
  @Test
  public void test009_removeEdgeWithBothVertexNotExist() {
    Graph testGraph009 = new Graph();
    testGraph009.addVertex("A");
    testGraph009.addVertex("B");
    testGraph009.addVertex("C");
    // without vertex "D","E"
    testGraph009.addEdge("A", "B");
    testGraph009.addEdge("A", "E");
    testGraph009.addEdge("B", "E");
    testGraph009.addEdge("B", "C");
    testGraph009.addEdge("C", "B");
    testGraph009.addEdge("D", "C");
    testGraph009.addEdge("D", "E");
    testGraph009.addEdge("E", "D");
    testGraph009.removeEdge("F", "G");
    int sizeResult = testGraph009.size();
    int orderResult = testGraph009.order();
    if (sizeResult != 7 && orderResult != 5) {
      fail("The size of the graph should be 7, but the result is " + sizeResult
          + "The order of the graph should be 5, but the result is " + orderResult);
    }
  }
  
  /**
   * Test whether the graph returns correct size and order after remove edges that are not in the graph
   */
  @Test
  public void test010_removeEdgWithEdgeNotInGraph() {
    Graph testGraph010 = new Graph();
    testGraph010.addVertex("A");
    testGraph010.addVertex("B");
    testGraph010.addVertex("C");
    // without vertex "D","E"
    testGraph010.addEdge("A", "B");
    testGraph010.addEdge("A", "E");
    testGraph010.addEdge("B", "E");
    testGraph010.addEdge("B", "C");
    testGraph010.addEdge("C", "B");
    testGraph010.addEdge("D", "C");
    testGraph010.addEdge("D", "E");
    testGraph010.addEdge("E", "D");
    testGraph010.removeEdge("F", "G");
    testGraph010.removeEdge("A", "C");
    int sizeResult = testGraph010.size();
    int orderResult = testGraph010.order();
    if (sizeResult != 7 && orderResult != 5) {
      fail("The size of the graph should be 7, but the result is " + sizeResult
          + "The order of the graph should be 5, but the result is " + orderResult);
    }
  }

/**
  * Test whether the graph returns correct list of adjacent vertices after add and remove some
  edges.
  */
  @Test
  public void test011_addEdge_removeEdge_getAdjacentVerticesOf() {
  Graph testGraph011 = new Graph();
  testGraph011.addVertex("A");
  testGraph011.addVertex("B");
  testGraph011.addVertex("C");
  testGraph011.addVertex("D");
  testGraph011.addVertex("E");
  testGraph011.addEdge("A", "B");
  testGraph011.addEdge("A", "E");
  testGraph011.addEdge("B", "E");
  testGraph011.addEdge("B", "C");
  testGraph011.addEdge("C", "B");
  testGraph011.addEdge("D", "C");
  testGraph011.addEdge("D", "E");
  testGraph011.addEdge("E", "D");
  testGraph011.removeEdge("C", "B");
  
  List<String> getAdjacentVerticesOfExpected = new ArrayList<String>();
  getAdjacentVerticesOfExpected.add("B");
  getAdjacentVerticesOfExpected.add("E");
  List<String> getAdjacentVerticesOfResult = testGraph011.getAdjacentVerticesOf("A");
  // Checking for every element in expected List
  for (final String element : getAdjacentVerticesOfExpected) {
  // if result List has the current element
  if (!getAdjacentVerticesOfResult.contains(element)) {
  fail("The expected List of adjacent vertice of the graph should be "
  + getAdjacentVerticesOfExpected + " , but the result is " + getAdjacentVerticesOfResult);
  }
  }
  }



}
