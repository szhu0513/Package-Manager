/////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////
// Title: P4 Package Manager
// Files: Graph.java
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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Directed and unweighted graph implementation
 */
public class Graph implements GraphADT {
  private List<String> vertices;
  private List<List<String>> edges; // use 2D arrayList to represent edges
  private int numOfVertices;
  private int numOfEdges;

  /**
   * Default no-argument constructor
   */
  public Graph() {
    this.vertices = new ArrayList<String>();
    this.edges = new ArrayList<>();
    this.numOfEdges = 0;
    this.numOfVertices = 0;
  }

  /**
   * Add new vertex to the graph. Valid argument conditions: 1. vertex is non-null 2. vertex is not
   * already in the graph
   * 
   * @param vertex the vertex that is going to be added
   * @see GraphADT#addVertex(String vertex)
   * 
   */
  @Override
  public void addVertex(String vertex) {
    if (!this.vertices.contains(vertex) && vertex != null) {
      this.vertices.add(vertex);
      edges.add(new ArrayList<>());
      this.numOfVertices++;
    }
  }

  /**
   * Remove a vertex and all associated edges from the graph. Valid argument conditions: 1. vertex
   * is non-null 2. vertex is already in the graph
   * 
   * @param vertex the vertex that is going to be removed
   * @see GraphADT#removeVertex(String vertex)
   * 
   */
  @Override
  public void removeVertex(String vertex) {
    if (this.vertices.contains(vertex) && vertex != null) {
      for (int j = 0; j < this.numOfVertices; j++) {
        if (vertices.get(j).equals(vertex)) {
          this.vertices.remove(j);
          this.numOfVertices--;
        }
      }
    }
  }

  /**
   * This is a private helper method which detect whether the given vertex is in the graph
   * 
   * @param vertex the vertex that is going to check
   */
  private void vertexHasContain(String vertex) {
    for (int from = 0; from < this.numOfVertices; from++) {
      if (!vertices.get(from).equals(vertex)) {
        addVertex(vertex);
      }
    }
  }

  /**
   * Add the edge from vertex1 to vertex2 to this graph. (edge is directed and unweighted) If either
   * vertex does not exist, no edge is added and no exception is thrown. If the edge exists in the
   * graph, no edge is added and no exception is thrown.
   * 
   * @param vertex1,vertex2 vertex1, the vertex that edge from; vertex 2, the vertex that edge point
   *        to
   * @see GraphADT#addEdge(String, String)
   */
  @Override
  public void addEdge(String vertex1, String vertex2) {
    if (vertex1 != null && vertex2 != null) {
      // check if two vertex in the graph, if not,add it
      vertexHasContain(vertex1);
      vertexHasContain(vertex2);
      for (int from = 0; from < this.numOfVertices; from++) {
        if (vertices.get(from).equals(vertex1)) {
          if (!edges.get(from).contains(vertex2))
            edges.get(from).add(vertex2);
          this.numOfEdges++;
        }
      }
    }
  }

  /**
   * Remove the edge from vertex1 to vertex2 from this graph. (edge is directed and unweighted) If
   * either vertex does not exist, or if an edge from vertex1 to vertex2 does not exist, no edge is
   * removed and no exception is thrown.
   * 
   * Valid argument conditions: 1. neither vertex is null 2. both vertices are in the graph 3. the
   * edge from vertex1 to vertex2 is in the graph
   * 
   * @param vertex1,vertex2 vertex1, the vertex that edge from; vertex 2, the vertex that edge point
   *        to
   * @see GraphADT#removeEdge(String, String)
   */
  @Override
  public void removeEdge(String vertex1, String vertex2) {
    if (vertex1 != null && vertex2 != null) {
      // check if the vertex1 in the 2D array
      for (int from = 0; from < this.numOfVertices; from++) {
        if (vertices.get(from).equals(vertex1)) {
          // check if the vertex2 in the 2D array
          if (edges.get(from).contains(vertex2)) {
            // remove the edge from vertex1 to vertex2 to this graph and decrease the number of
            // edges
            edges.get(from).remove(vertex2);
            this.numOfEdges--;
          }
        }
      }
    }
  }


  /**
   * Returns a Set that contains all the vertices
   * 
   * @see GraphADT#getAllVertices()
   * 
   */
  @Override
  public Set<String> getAllVertices() {
    Set<String> returnSet = new HashSet<String>(this.vertices);
    return returnSet;
  }

  /**
   * Get all the neighbor (adjacent) vertices of a vertex
   * 
   * @param vertex the vertex to find the neighbor
   * @see GraphADT#getAdjacentVerticesOf(String)
   *
   */
  @Override
  public List<String> getAdjacentVerticesOf(String vertex) {
    List<String> returnList = new ArrayList<String>();
    if (vertex != null) {
      // check if the vertex is in the graph
      for (int from = 0; from < this.numOfVertices; from++) {
        if (vertices.get(from).equals(vertex)) {
          for (int to = 0; to < this.edges.get(from).size(); to++) {
            returnList.add(edges.get(from).get(to));
          }
        }
      }
    }
    return returnList;
  }

  /**
   * Returns the number of edges in this graph.
   * 
   * @see GraphADT#size()
   */
  @Override
  public int size() {
    return this.numOfEdges;
  }

  /**
   * Returns the number of vertices in this graph.
   * 
   * @see GraphADT#order()
   */
  @Override
  public int order() {
    return this.numOfVertices;
  }
}
