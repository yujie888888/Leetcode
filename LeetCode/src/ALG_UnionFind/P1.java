/**
 * You are given an array of string arrays called requests and an integer totaisletsrepresenting the total size of a memory system. requests has request arrays of stze3 to store or free a certain number of slots in this system, All the slots are initiallyfree. Assume all the slots are connected in a loop, and the last slot is circularlyconnected to the first slot, Your task is to return a? ordered array of the return valuesfrom the processed requests in the same order as in the requests array.
 *
 * Two types of requests are:
 *
 * 1.["store","<startIndex>","<numberofSlots>"]
 * It is a request to allocate the numberofslots slots, beginning at the startIndex
 * startIndex : Preferred slot index of the start of the memory allocation.o lf the memory slot beginning at startIndex is already in use, check thenext available memory slot, continuing until numberofslots contiguousunoccupied slots are found. Since the last slot is connected to the firstslot, a valid slot may span from the last index through the first index. Forinstance, in a system with 10 slots, to allocate numberofslots =5 youcan use a slot from index 8 through index 2
 *
 * If the request cannot be satisfied, no slot are allocated for the request, and the operation returns -1
 * Otherwise, return the index of the start of the allocated memory block.
 * After a successful request, these slots will stay reserved until they arefreed with the free request.。numberofslots :The number of contiguous slots to store
 *
 * 2.["free","<startIndex>","<numberofSlots>"]
 *
 * It is a reguest to free the numberofslots slots beginning from the startIndex
 *
 * startIndex : Index of where the memory de-allocation needs to start. Slotsfrom startIndex to startIndex + numberOfslots are guaranteed to be Return the number of slots freed i.e. numberofslotsoThese slots will be available again for storage.numberofslots : The number of slots to be freed starting from startIrde
 */
package ALG_UnionFind;

public class P1 {
    public static void main(String[] args){

    }
}
