class Solution {

    class Room {
        long end;
        int room;

        Room(long end, int room) {
            this.end = end;
            this.room = room;
        }
    }

    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        PriorityQueue<Integer> empty = new PriorityQueue<>();

        PriorityQueue<Room> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a.end != b.end)
                    return Long.compare(a.end, b.end);

                return Integer.compare(a.room, b.room);
            }
        );

        int[] meetCount = new int[n];

        for (int i = 0; i < n; i++) {
            empty.add(i);
        }

        for (int[] meet : meetings) {

            int s = meet[0];
            int e = meet[1];

            // Free all rooms available by meeting start
            while (!busy.isEmpty() && busy.peek().end <= s) {
                empty.add(busy.poll().room);
            }

            // Some room is available
            if (!empty.isEmpty()) {

                int room = empty.poll();

                busy.add(new Room(e, room));

                meetCount[room]++;
            }

            // All rooms are busy
            else {

                Room temp = busy.poll();

                long duration = (long)e - s;

                busy.add(new Room(
                    temp.end + duration,
                    temp.room
                ));

                meetCount[temp.room]++;
            }
        }

        int maxMeet = 0;

        for (int i = 1; i < n; i++) {
            if (meetCount[i] > meetCount[maxMeet]) {
                maxMeet = i;
            }
        }

        return maxMeet;
    }
}