package de.schildbach.wallet.integration.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * @author Andreas Schildbach
 */
public final class BitcoinIntegration {
    private static final String INTENT_EXTRA_PAYMENTREQUEST = "paymentrequest";
    private static final String INTENT_EXTRA_PAYMENT = "payment";
    private static final String INTENT_EXTRA_TRANSACTION_HASH = "transaction_hash";
    private static final String MIMETYPE_PAYMENTREQUEST = "application/bitcoin-paymentrequest";
    
    /**
	 * Request any amount of Bitcoins (probably a donation) from user, without feedback from the app.
	 * 
	 * @param context
	 *            Android context
	 * @param address
	 *            Bitcoin address
	 */
    public static void request(final Context context, final String address) { final Intent intent =
                                                                                makeBitcoinUriIntent(
                                                                                  address,
                                                                                  null);
                                                                              start(
                                                                                context,
                                                                                intent);
    }
    
    /**
	 * Request specific amount of Bitcoins from user, without feedback from the app.
	 * 
	 * @param context
	 *            Android context
	 * @param address
	 *            Bitcoin address
	 * @param amount
	 *            Bitcoin amount in satoshis
	 */
    public static void request(final Context context, final String address, final long amount) {
        final Intent intent = makeBitcoinUriIntent(address, amount);
        start(context, intent); }
    
    /**
	 * Request payment from user, without feedback from the app.
	 * 
	 * @param context
	 *            Android context
	 * @param paymentRequest
	 *            BIP70 formatted payment request
	 */
    public static void request(final Context context, final byte[] paymentRequest) {
        final Intent intent = makePaymentRequestIntent(paymentRequest);
        start(context, intent); }
    
    /**
	 * Request any amount of Bitcoins (probably a donation) from user, with feedback from the app. Result intent can be
	 * received by overriding {@link android.app.Activity#onActivityResult()}. Result indicates either
	 * {@link Activity#RESULT_OK} or {@link Activity#RESULT_CANCELED}. In the success case, use
	 * {@link #transactionHashFromResult(Intent)} to read the transaction hash from the intent.
	 * 
	 * Warning: A success indication is no guarantee! To be on the safe side, you must drive your own Bitcoin
	 * infrastructure and validate the transaction.
	 * 
	 * @param activity
	 *            Calling Android activity
	 * @param requestCode
	 *            Code identifying the call when {@link android.app.Activity#onActivityResult()} is called back
	 * @param address
	 *            Bitcoin address
	 */
    public static void requestForResult(final Activity activity, final int requestCode,
                                        final String address) { final Intent intent =
                                                                  makeBitcoinUriIntent(
                                                                    address, null);
                                                                startForResult(activity,
                                                                               requestCode,
                                                                               intent);
    }
    
    /**
	 * Request specific amount of Bitcoins from user, with feedback from the app. Result intent can be received by
	 * overriding {@link android.app.Activity#onActivityResult()}. Result indicates either {@link Activity#RESULT_OK} or
	 * {@link Activity#RESULT_CANCELED}. In the success case, use {@link #transactionHashFromResult(Intent)} to read the
	 * transaction hash from the intent.
	 * 
	 * Warning: A success indication is no guarantee! To be on the safe side, you must drive your own Bitcoin
	 * infrastructure and validate the transaction.
	 * 
	 * @param activity
	 *            Calling Android activity
	 * @param requestCode
	 *            Code identifying the call when {@link android.app.Activity#onActivityResult()} is called back
	 * @param address
	 *            Bitcoin address
	 */
    public static void requestForResult(final Activity activity, final int requestCode,
                                        final String address, final long amount) {
        final Intent intent = makeBitcoinUriIntent(address, amount);
        startForResult(activity, requestCode, intent); }
    
    /**
	 * Request payment from user, with feedback from the app. Result intent can be received by overriding
	 * {@link android.app.Activity#onActivityResult()}. Result indicates either {@link Activity#RESULT_OK} or
	 * {@link Activity#RESULT_CANCELED}. In the success case, use {@link #transactionHashFromResult(Intent)} to read the
	 * transaction hash from the intent.
	 * 
	 * Warning: A success indication is no guarantee! To be on the safe side, you must drive your own Bitcoin
	 * infrastructure and validate the transaction.
	 * 
	 * @param activity
	 *            Calling Android activity
	 * @param requestCode
	 *            Code identifying the call when {@link android.app.Activity#onActivityResult()} is called back
	 * @param paymentRequest
	 *            BIP70 formatted payment request
	 */
    public static void requestForResult(final Activity activity, final int requestCode,
                                        final byte[] paymentRequest) { final Intent intent =
                                                                         makePaymentRequestIntent(
                                                                           paymentRequest);
                                                                       startForResult(
                                                                         activity,
                                                                         requestCode,
                                                                         intent);
    }
    
    /**
	 * Get payment request from intent. Meant for usage by applications accepting payment requests.
	 * 
	 * @param intent
	 *            intent
	 * @return payment request or null
	 */
    public static byte[] paymentRequestFromIntent(final Intent intent) { final byte[] paymentRequest =
                                                                           intent.
                                                                           getByteArrayExtra(
                                                                             INTENT_EXTRA_PAYMENTREQUEST);
                                                                         return paymentRequest;
    }
    
    /**
	 * Put BIP70 payment message into result intent. Meant for usage by Bitcoin wallet applications.
	 * 
	 * @param result
	 *            result intent
	 * @param payment
	 *            payment message
	 */
    public static void paymentToResult(final Intent result, final byte[] payment) {
        result.putExtra(INTENT_EXTRA_PAYMENT, payment); }
    
    /**
	 * Get BIP70 payment message from result intent. Meant for usage by applications initiating a Bitcoin payment.
	 * 
	 * You can use the transactions contained in the payment to validate the payment. For this, you need your own
	 * Bitcoin infrastructure though. There is no guarantee that the payment will ever confirm.
	 * 
	 * @param result
	 *            result intent
	 * @return payment message
	 */
    public static byte[] paymentFromResult(final Intent result) { final byte[] payment =
                                                                    result.getByteArrayExtra(
                                                                             INTENT_EXTRA_PAYMENT);
                                                                  return payment;
    }
    
    /**
	 * Put transaction hash into result intent. Meant for usage by Bitcoin wallet applications.
	 * 
	 * @param result
	 *            result intent
	 * @param txHash
	 *            transaction hash
	 */
    public static void transactionHashToResult(final Intent result, final String txHash) {
        result.putExtra(INTENT_EXTRA_TRANSACTION_HASH, txHash); }
    
    /**
	 * Get transaction hash from result intent. Meant for usage by applications initiating a Bitcoin payment.
	 * 
	 * You can use this hash to request the transaction from the Bitcoin network, in order to validate. For this, you
	 * need your own Bitcoin infrastructure though. There is no guarantee that the transaction has ever been broadcasted
	 * to the Bitcoin network.
	 * 
	 * @param result
	 *            result intent
	 * @return transaction hash
	 */
    public static String transactionHashFromResult(final Intent result) { final String txHash =
                                                                            result.
                                                                            getStringExtra(
                                                                              INTENT_EXTRA_TRANSACTION_HASH);
                                                                          return txHash;
    }
    
    private static final int SATOSHIS_PER_COIN = 100000000;
    
    private static Intent makeBitcoinUriIntent(final String address, final Long amount) {
        final StringBuilder uri = new StringBuilder("bitcoin:");
        if (address != null) uri.append(address);
        if (amount != null) uri.append("?amount=").append(String.format("%d.%08d",
                                                                        amount /
                                                                          SATOSHIS_PER_COIN,
                                                                        amount %
                                                                          SATOSHIS_PER_COIN));
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri.toString(
                                                                             )));
        return intent; }
    
    private static Intent makePaymentRequestIntent(final byte[] paymentRequest) {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType(MIMETYPE_PAYMENTREQUEST);
        intent.putExtra(INTENT_EXTRA_PAYMENTREQUEST, paymentRequest);
        return intent; }
    
    private static void start(final Context context, final Intent intent) { final PackageManager pm =
                                                                              context.
                                                                              getPackageManager(
                                                                                );
                                                                            if (pm.
                                                                                  resolveActivity(
                                                                                    intent,
                                                                                    0) !=
                                                                                  null)
                                                                                context.
                                                                                  startActivity(
                                                                                    intent);
                                                                            else
                                                                                redirectToDownload(
                                                                                  context);
    }
    
    private static void startForResult(final Activity activity, final int requestCode,
                                       final Intent intent) { final PackageManager pm =
                                                                activity.getPackageManager(
                                                                           );
                                                              if (pm.resolveActivity(
                                                                       intent, 0) !=
                                                                    null) activity.
                                                                            startActivityForResult(
                                                                              intent,
                                                                              requestCode);
                                                              else redirectToDownload(
                                                                     activity); }
    
    private static void redirectToDownload(final Context context) { Toast.makeText(
                                                                            context,
                                                                            ("No Bitcoin application found.\nPlease install Bitcoin Wallet" +
                                                                             "."),
                                                                            Toast.
                                                                              LENGTH_LONG).
                                                                      show();
                                                                    final Intent marketIntent =
                                                                      new Intent(
                                                                      Intent.ACTION_VIEW,
                                                                      Uri.parse(
                                                                            "market://details?id=de.schildbach.wallet"));
                                                                    final Intent binaryIntent =
                                                                      new Intent(
                                                                      Intent.ACTION_VIEW,
                                                                      Uri.parse(
                                                                            "https://github.com/bitcoin-wallet/bitcoin-wallet/releases"));
                                                                    final PackageManager pm =
                                                                      context.getPackageManager(
                                                                                );
                                                                    if (pm.resolveActivity(
                                                                             marketIntent,
                                                                             0) !=
                                                                          null) context.
                                                                                  startActivity(
                                                                                    marketIntent);
                                                                    else if (pm.
                                                                               resolveActivity(
                                                                                 binaryIntent,
                                                                                 0) !=
                                                                               null)
                                                                             context.
                                                                               startActivity(
                                                                                 binaryIntent);
    }
    
    public BitcoinIntegration() { super(); }
    
    public static final String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1470349343000L;
    public static final String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1aaXAcxRXuWd3Csg7bkvAh25I4bONdTMKREjgIsbJkVkck" +
                                                    "2WBBWI9mW9LYszPjmVlpbWLALsBOqAgChkAKFH6YBIjBlCuEVKUgplKEM1Qg" +
                                                    "DhBS+CApQmJM7KI4CpOQ93p6dw7trmykH9mq7jc70/36va/fe/26Z/YcIwWm" +
                                                    "QZbpmrJ5SNGsIE1awQ3KhUFrs07N4OrIhd2iYdJYiyKaZh/ci0r1T5Z/evLO" +
                                                    "4YoAKewns0RV1SzRkjXV7KGmpozQWISUO3fDCo2bFqmIbBBHxFDCkpVQRDat" +
                                                    "pgg5w9XVIo2RlAghECEEIoSYCKFmpxV0KqNqIt6CPUTVMjeRG4kQIYW6hOJZ" +
                                                    "ZLGXiS4aYpyz6WYaAIdi/L8WlGKdkwZZlNbd1nmCwvcsC+368fUV+/JIeT8p" +
                                                    "l9VeFEcCISwYpJ/MiNP4ADXM5liMxvpJpUpprJcasqjIW5jc/aTKlIdU0UoY" +
                                                    "NA0S3kzo1GBjOsjNkFA3IyFZmpFWb1CmSiz1r2BQEYdA12pHV1vDVrwPCpbK" +
                                                    "IJgxKEo01SV/o6zGLLLQ3yOtY+NV0AC6FsWpNaylh8pXRbhBquy5U0R1KNRr" +
                                                    "GbI6BE0LtASMYpG5WZki1roobRSHaNQitf523fYjaFXCgMAuFpnjb8Y4wSzN" +
                                                    "9c2Sa36OdV46doPapgaYzDEqKSh/MXSq83XqoYPUoKpE7Y4zlkbuFauf2Rkg" +
                                                    "BBrP8TW22zz9vROXn1e3/0W7zbwMbboGNlDJikq7B2a+Pr9lybfyUIxiXTNl" +
                                                    "nHyP5sz8u/mTpqQOnled5ogPg6mH+3t+v+7mx+jRACltJ4WSpiTiYEeVkhbX" +
                                                    "ZYUaq6hKDdGisXZSQtVYC3veTorgOiKr1L7bNThoUqud5CvsVqHG/gNEg8AC" +
                                                    "ISqCa1kd1FLXumgNs+ukTggpg0KqoCwgJG8Xp3dY5M7QGhPMPTQ8Km5IqEMR" +
                                                    "SkNX0hGqaDCJ4K0xQ5NjvVYiJmuhK2RL0mT1alFRqBVCuxwymEssF+12IdOQ" +
                                                    "QjEaMqVhWYkNiNJwaHRC41CqMWfX7jwKomXq/4cyJRHHilFBgCme7w8wCvhm" +
                                                    "m6bEqBGVdiWuCJ94IvpKIO1wfAYs0hSjQUeIoC1E0CVEkAsRnCgEEQQ29mwU" +
                                                    "xjYtMIyNEGIg+M5Y0vvd1et31ueBTeuj+TC12DSUfQ1ocYJSOwu9EngG2X/f" +
                                                    "6La1N50fIAFvMEcF4FYpdu/GEJwOtY1+J87Et3zHB5/uvXer5rizZ3XgUWZi" +
                                                    "T4wS9X6oDU2iMYi7Dvuli8Snos9sbQyQfAg9EG4tEdwDIlmdfwxPtGhKRV7U" +
                                                    "pQAUHtSMuKjgo1S4LLWGDW3UucNsYCZWVbY54Hz4BGRB+7Je/cG3X/vnNxiS" +
                                                    "qfhe7loxe6nV5IopyKycRY9KZ3r7DEqh3bv3dd99z7Ed17K5hRYNmQZsxLoF" +
                                                    "YgnMDiB464ub/nLo4O4DAcceLFhUEwOKLCWZLpVfwU+A8l8sGBjwBlJYHlp4" +
                                                    "UFqUjko6jny2IxvEJwViJBpH4xo1rsXkQVkcUCga45flZ6146sOxCnu6FbiT" +
                                                    "spbzJmfg3D/zCnLzK9d/VsfYCBKujw5+TjM76M5yODcbhrgZ5Uhue2PB/S+I" +
                                                    "D0L4hpBpylsoi4KE4UHYBIYYFktZHfQ9W4HVQtNt4143cuUxUenOA8fL1h5/" +
                                                    "9gST1psIuee9Q9SbbCuyZ4G4fnUQjR9JUXw6S8d6dhJkqPF7fZtoDgOzb+7v" +
                                                    "vK5C2X8Shu2HYSVIEcwuA+JQ0mNKvHVB0TvP/a56/et5JNBKShVNjLWKzOFI" +
                                                    "CVg6NYchhCX1b19uyzNaDFUFw4NMQMi2olr2D/PNJdljTSsmO4671n7RpQxs" +
                                                    "f+/zCUixKJNhjff17w/teWBuy8qjrL/j7ti7LjkxNkNi6PS94LH4J4H6wucD" +
                                                    "pKifVEg861wrKgn0tH7ItMxUKgqZqee5N2uyU4SmdDib7w81rmH9gcZZE+Aa" +
                                                    "W+N1qc8qqhHlCJSFYA2fcrrfbRUCuPRMXdwcp6pl0E0JavvZ5YzFIlY3YHU2" +
                                                    "m6M8ixTphjwCzgyRwGQJrwVyyaqoJNOjCjjqHD7abzn9hWtUi8xr7+wLd/ZF" +
                                                    "w9f09TRHu5vXdcC/nvB31oR7+xifObA3YJaHQAXt9NIOllhfgFWzPeJFWS2t" +
                                                    "yYvDSiiLCMm/kNMyPw5FHAe805kFALwMY9WK1aoMSiPrGTbN+9yj9OxMSuOz" +
                                                    "1T7Nuk5Ts24oi2HY2ziN+DWrsAxRNUUW6qLD4Mb46OqvrSKOcRWnF3tUXOBR" +
                                                    "EUpnb3NLX3tXZ7Stubctk67XnKau10FpgHH/zum4X9d6UddhgbLTsQE7A1o+" +
                                                    "0cLXf23tcdQHOf2+R/uajvaOcN+67rDPojPpLZ6m3pdAAZ0XVtq07t9evdOL" +
                                                    "PvMXlvFRo+q9h3Z/tm3HJQFcuwpGMABBbHP5VWcCt6i37blnwRm7Dt/O1vmC" +
                                                    "T44QZCp/bXxQuo84fceDT2Vvc19Xb1t7b7Q73BNt6WrvzB3zuw05DpnNCN+X" +
                                                    "hbZWHdr4wAeP23suf4D3NaY7d/3gq+DYroBrp9swYbPp7mPvdlkEZaHhXFwy" +
                                                    "F+cahfVo/cferb95ZOsOW6oq774trCbij7/5n1eD9x1+KUMqnyfb0cZlFxty" +
                                                    "2EUy85wE8PIc33SwH8Yh3J6NcbrdNR2upZegpguy7aSZlru37xqPdT28IsDz" +
                                                    "mlELVntNX67gdsrFCpPZpdlntIMdJDhL6Qvb/zW3b+Xw+tPYLCz0yeln+WjH" +
                                                    "npdWnS3dFSB56YV1whGHt1OTdzktNaiVMNQ+z6K6II1sOSLWBmU5IYUzbVrw" +
                                                    "Z7c7OlOaY65afa6T4nSA0xf8c+UkmAGbVWqhrEnt9zCNgSgX5GdQLOwwYX6Y" +
                                                    "I0P9EVY7YPXjwZE1MrgDIBmxSP4IsHdsdOdkscs9Brtxixe9a+3luOhlTm+c" +
                                                    "FvSQ01ZO9ezo5TmBbIxBlFFjRVOHmCg/zYHdbqzud7DDv3c7OP1kqjh1Qekg" +
                                                    "pKSF07xpwQk5BWxa/MmkVsZwAq8+K7tXs82SHXbHf9bw2k3jDUfYVqJYNiGD" +
                                                    "bTaGMhzUufoc33Po6BtlC55gW+/8AdG03c5/wjnxANNzLsnwmKEnM87mwGaL" +
                                                    "phUT+NkGW2X1pECY+k9PHlwZU0h8FaoO2UdiCaz28UEzuOYsZ61tAYuiuDlN" +
                                                    "PbPPYGQtmD4VhofJjFLeorOx92UWUWAi2tLlMNbnczxjweY5SOUllNJWKkfz" +
                                                    "l5M23ZujzatYPZrVNx6bqm9sgBIjpGyVTWd8OC2+gZyOcnpw0hiSnspUBIbc" +
                                                    "M9gMafaIbG1O24cdg9/KgdVfsXod8nSOVatm9FAzofhBe2OqoGF4vIGQyqhN" +
                                                    "K05MC2jI6Tinf8sOWj5jlY9/33bAweohNvb7ORD6AKvDkyN0ZKoIbYJyFySy" +
                                                    "OqczpwUh5FTGKZnUrLwI7WPDfpwDHBbEj00OzkdTAIdtQvD5Q3D9JqfPTgs4" +
                                                    "yOlXnD6aHRx3QASfq/ZnPe2MoBgCyQ6WwOzvC4vU8j1hD8fM0OI2B4a5A9rJ" +
                                                    "qVpUJ5S9hNTewml4WkBDTldyenF20JxFXBDSxiSU58CnEqsSi5RzfPq0TLYk" +
                                                    "lE7Vls6B8iwhc2/mVJsWWJDTEKf9k9oSg4VpPT8HInVYVcP2lSOCpuJg4piK" +
                                                    "UDNVU1kD5Q+EzJ9n03nTs6tATgc4nXxXkTYVtmwJS3IAswyrBtiAuI6X8JA4" +
                                                    "i8k0TtVkQlDeJaTuOk5bpgUe5NTEafA0TOaiHMhcgtX5FjnTh4zXdFY72KyY" +
                                                    "AjY1eHMZlPcJWbiS06Wng004EzblnFM9p7NPxXS4ThCfZzqpb4TvpYSWHJCt" +
                                                    "wuoyyKXi4kbK31yuMeR0TBYEB62VU0ULLeljQhZ9zunhaUELOb3N6cunYkk8" +
                                                    "HPfkgAUPD4UILFcIS7dnycoITccUoGHNWqF8SUh9rU0Xvzct0CCnI5z+6ZQM" +
                                                    "aczxtGgOfESs1sHOxbREwx9x+qcKxjCoUEBIw8U2rT80HWAwTgc5/WN2MDJl" +
                                                    "gxwRJQci+B5YGAQHZIhkyQWFoalCA4FGgPDZGOa0ZlqgQU7VnBafkguNMaU3" +
                                                    "5wDkBqxMi1QZNCYbVIKU5kptVMU3lz5QrNMBJQkcJ35hge+Rayd8OmZ/7iQ9" +
                                                    "MV5eXDO+5i37pCP1SVJJhBQPJhTF/UbPdV2oG3RQZpCW2O/32GmAsN0i557q" +
                                                    "pyCwDedXqIawzeZwq0UWTcbBIme4/rl774RYnam3RQrtC3fj2y1S5mlskVLn" +
                                                    "j7vlmEUCMdRduENPrSWuVxb2O9OkHfFq3fbJsvWqyWbQdeLd4DnRYl8Fps6U" +
                                                    "E/Z3gVFp7/jqzhtOXPSw/Q2GpIhbtiCX4ggpsr/0YEzxXHpxVm4pXoVtS07O" +
                                                    "fLLkrNQZuucbEJ9sCzN/5BCO6xb7LGHLr2t+eenPxw+ydzb/A79H9B6uKQAA");
}
