using System;
using System.Runtime.Serialization;

namespace LinkedLists
{
    class Program
    {
        static void Main(string[] args)
        {
            Node firstNumber = new Node(7, 
                new Node(1, 
                new Node( 6, null)));

            Node secondNumber = null;

            Node result = ReverseLinkedListSum(firstNumber, secondNumber);
            printLinkedList(result);
            Console.WriteLine(617 + 95);
        }

        static Node ReverseLinkedListSum(Node firstNumber, Node secondNumber)
        {
            Node sum = null;
            int carryOver = 0;
            Node pointer = null;

            while(firstNumber != null || secondNumber != null)
            {
                var firstVal = firstNumber == null ? 0 : firstNumber._val;
                var secondVal = secondNumber == null ? 0 : secondNumber._val;
                var s = firstVal + secondVal + carryOver;
                carryOver = s / 10;
                var nodeValue = s % 10;
                if(sum == null)
                {
                    sum = new Node(nodeValue, null);
                    pointer = sum;
                }
                else
                {
                    pointer._next = new Node(nodeValue, null);
                    pointer = pointer._next;
                }
                firstNumber = firstNumber?._next;
                secondNumber = secondNumber?._next;
            }

            if(carryOver != 0)
            {
                pointer._next = new Node(carryOver, null);
            }
            return sum;
        }

        static Node ForwardLinkedListSum(Node firstNumber, Node secondNumber)
        {
            Node sum = null;
            int carryOver = 0;
            Node pointer = null;

            while (firstNumber != null || secondNumber != null)
            {
                var firstVal = firstNumber == null ? 0 : firstNumber._val;
                var secondVal = secondNumber == null ? 0 : secondNumber._val;
                var s = firstVal + secondVal + carryOver;
                carryOver = s / 10;
                var nodeValue = s % 10;
                if (sum == null)
                {
                    sum = new Node(nodeValue, null);
                    pointer = sum;
                }
                else
                {
                    pointer._next = new Node(nodeValue, null);
                    pointer = pointer._next;
                }
                firstNumber = firstNumber?._next;
                secondNumber = secondNumber?._next;
            }

            if (carryOver != 0)
            {
                pointer._next = new Node(carryOver, null);
            }
            return sum;
        }

        public static void printLinkedList(Node result)
        {
            while (result != null)
            {
                Console.WriteLine(result._val);
                result = result._next;
            }
        }

        public class Node
        {
            public int _val;
            public Node _next;

            public Node(int val, Node next)
            {
                _val = val;
                _next = next;

            }
        }
    }
}
