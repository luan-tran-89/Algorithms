package com.interview.amazon.assessment.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Amazon ships millions of packages every day.
 * A large percentage of them are fulfilled by Amazon, so it is important to minimize shipping costs.
 * It has been found that moving a group of 3 packages to the shipping facility together is most efficient.
 *
 * The shipping process needs to be optimized at a new warehouse.
 * There are the following types of queries or requests:
 *  - INSERT package_id: insert package_id in the queue of packages to be shipped
 *  - SHIP -: ship the group of 3 items that were in the queue earliest i.e. they are returned in the order they entered
 * Perform q queries and return a list of lists, one for every SHIP - type query.
 * The lists are either:
 *  3 package ID strings in the order they were queued.
 *  Or,ii there are not enough packages ni the queue to fulfill the query, the result is ["N/A"].
 *
 * Note:
 *  - Initially, the queue is empty.
 *  - The list of packages shipped per group should be in the order they were queued.
 *  - There is at least one query of the 2nd type.
 *
 *  The function performQueries take List> of type String as a parameter which contains each query where
 *      list.get(i).get(0) = INSERT | SHIP
 *      list.get(i).get(1) = shipmentID | -
 *
 *  Example:
 *      Perform a series of queries.
 *      INSERT NJ513501348: Insert a new package with
 *          package_id NI513501348
 *      INSERT GP235136011: Insert a new package with
 *          package_id GP235136011
 *      INSERT ER6245096201: Insert a new package with
 *          package_id ER6245096201
 *      INSERT NJ7006246135: Insert a new package with
 *          package_id NJ7006246135
 *      SHIP - : Ship the first group of 3 packages. Now there is only one package in the queue.
 *
 *      Return [['NJ513501348, 'GP235136011', 'ER6245096201']].
 *
 * Function Description:
 *  Complete the function performWarehouseQueries in the editor below.
 *
 *  performWarehouseQueries has the following parameter:
 *      query[q][2]: a 2d array of strings of size q * 2 where each row represents the query to perform
 *  Returns
 *      string[q][1 or 3]: the list of groups of packages or "N/A" for each query of the 2nd type
 *
 * Constraints
 *  1 <= q ≤ 5•10^5
 *  1 <= |package_id| ≤ 10
 *  package_id is alphanumeric, [0-9, a-z, A- Z]
 *  There is at least one query of the 2nd type.
 *
 *  Sample Case 0:
 *      INSERT GT23513413
 *      INSERT TQC2451340
 *      SHIP
 *      INSERT VYP8561991
 *      SHIP
 *
 *      Output:
 *          N/A
 *          GT23513413 TQC2451340
 *          VYP8561991
 *      Explanation:
 *          INSERT GT23513413: Insert a new package with
 *              package_id GT23513413.
 *              The queue is: [GT23513413]
 *          INSERT TQC2451340: Insert a new package with
 *              package_id TQC2451340.
 *              The queue is: [GT23513413, TQC2451340]
 *          SHIP:- Since the queue does not have 3 items yet, the shipment cannot be completed.
 *              The result is ["N/A"]
 *          INSERT VYP8561991: Insert a new package with
 *              package_id VYP8561991. The queue is: [GT23513413, TQC2451340, VYP8561991]
 *          SHIP -: The queue now has 3 packages that can be delivered.
 *              The result is [GT23513413", "TQC2451340", "VYP8561991"]. The queue is empty.
 *          Return [["N/A"], ["GT23513413", "TQC2451340", "VYP8561991"]].
 *
 * Sample Case 1:
 *
 *      Sample Output:
 *          YQV041FGWF 00135SVDWV
 *          VP9FP23411
 *          VYP8561001 PP02351I32
 *          R2G04F0134
 *
 *       Explanation:
 *          INSERT YQV041FGWF: Insert a new package with
 *              package_id YQV041FGWF.
 *              The queue is: [YQV041FGWF]
 *          INSERT 00135SVDWV: Insert a new package with
 *              package_ id 00135SVDWV.
 *              The queue is: [YQV041FGWF, 00135SVDWV]
 *          INSERT VP9FP23411: Insert a new
 *              package_ id VP9FP23411.
 *              The queue is: [YQV041FGWF, 00135SVDWV, VP9FP23411]
 *          SHIP -: The queue now has 3 packages that can be delivered.
 *              The result is [YQV041FGWF, 00135SVDWV, VP9FP23411]. The queue is now empty.
 *          INSERT VYP8561001: Insert a new package with
 *              package_id VYP8561001.
 *              The queue is: [VYP8561001]
 *          INSERT PP02351132: Insert a new package with
 *              package_id PP02351132.
 *              The queue is: [WYP8561001, PP02351132]
 *          INSERT R2G04F0134: Insert a new
 *              package with package_id R2G04F0134.
 *              The queue is: [VYP8561001, PP02351132, R2G04F0134]
 *          SHIP: The queue now has 3 packages that can be delivered.
 *              The result si ["VYP8561001", "PP02351132", "R2G04F0134" .]
 *              The queue is now empty.
 *          Return
 *          [
 *              [I"YOVO4hFGWF", "00135SVDWV", "VP9FP23411"],
 *              ["VYP8561001", "PP02351132", "R2G04F0134"]
 *          ]
 *
 * @author gasieugru
 */
public class Prob1 {

    public static void main(String[] args) {

        List<String> package1 = new ArrayList<>();
        package1.add("INSERT");
        package1.add("GT23513413");

        List<String> package2 = new ArrayList<>();
        package2.add("INSERT");
        package2.add("TQC2451340");

        List<String> package3 = new ArrayList<>();
        package3.add("SHIP");

        List<String> package4 = new ArrayList<>();
        package4.add("INSERT");
        package4.add("VYP8561991");

        List<String> package5 = new ArrayList<>();
        package5.add("SHIP");


        List<List<String>> packages = new ArrayList<>();
        packages.add(package1);
        packages.add(package2);
        packages.add(package3);
        packages.add(package4);
        packages.add(package5);

        System.out.println(performWarehouseQueriesList(packages));
    }

    private static final String NA = "N/A";

    public static List<List<String>> performWarehouseQueriesList(List<List<String>> query) {
        List<List<String>> res = new ArrayList<>();
        List<String> data = new ArrayList<>();

        for (List<String> list : query) {
            String type = list.get(0);
            if ("INSERT".equals(type)) {
                data.add(list.get(1));
            } else if ("SHIP".equals(type)){
                if (data.size() == 3) {
                    res.add(new ArrayList<>(data));
                    data.clear();
                } else {
                    res.add(Arrays.asList(NA));
                }
            }
        }

        return res;
    }
}
