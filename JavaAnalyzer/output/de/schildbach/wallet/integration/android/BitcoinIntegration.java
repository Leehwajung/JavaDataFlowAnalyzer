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
    public static final long jlc$SourceLastModified$jl7 = 1470345481587L;
    public static final String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAM1aaXAcxRXuWd1Csg7bkvAh25I4bOMVJuFIBA5CrCyZ1RFJ" +
                                                    "NlhsWI9mW9LYszPjmVlpbccBuwA7oSIICAIpUPhhEiAGU64QUpWCmEoRzlCB" +
                                                    "OEBI4YOkCIkxsYviKExC3uvp3Zkd7a5spB/Zqu43O9P9+r2vX399zOw9TvJM" +
                                                    "gyzXNWXLkKJZfhq3/BuVi/3WFp2a/jXBi7tFw6SRFkU0zT64F5bqnij75NQd" +
                                                    "w+U+kt9PZouqqlmiJWuq2UNNTRmhkSApc+4GFBo1LVIe3CiOiI0xS1Yag7Jp" +
                                                    "NQXJWa6qFmkIJkxoBBMawYRGZkJjs1MKKpVSNRZtwRqiapmbyfeIECT5uoTm" +
                                                    "WWRJqhJdNMQoV9PNPAANhfh/HTjFKscNsjjpu+3zJIfvXt44/uMbyvfnkLJ+" +
                                                    "UiarvWiOBEZY0Eg/KYnS6AA1zOZIhEb6SYVKaaSXGrKoyFuZ3f2k0pSHVNGK" +
                                                    "GTQJEt6M6dRgbTrIlUjomxGTLM1IujcoUyWS+Jc3qIhD4GuV46vtYSveBweL" +
                                                    "ZTDMGBQlmqiSu0lWIxZZ5K2R9LHhGigAVQui1BrWkk3lqiLcIJV23ymiOtTY" +
                                                    "axmyOgRF87QYtGKReRmVIta6KG0Sh2jYIjXect32IyhVxIDAKhaZ6y3GNEEv" +
                                                    "zfP0kqt/jndePrZNbVN9zOYIlRS0vxAq1Xoq9dBBalBVonbFkmXBe8Sqp3f7" +
                                                    "CIHCcz2F7TJPfffklRfUHnjBLjM/TZmugY1UssLSnoFZry1oWfqNHDSjUNdM" +
                                                    "GTs/xXMW/t38SVNch5FXldSID/2Jhwd6fr/+pkfpMR8pbif5kqbEohBHFZIW" +
                                                    "1WWFGqupSg3RopF2UkTVSAt73k4K4Dooq9S+2zU4aFKrneQq7Fa+xv4DRIOg" +
                                                    "AiEqgGtZHdQS17poDbPruE4IKYVEKiEtJCRnnMvbLTIe+GZorQkBHwq2rQld" +
                                                    "TUeookH/ha7VjE290OE0tAbCJTQgW5ImqytGRUWh1oqoaEK8hDA2hww2LFaI" +
                                                    "asTQ5EjINKRQhIZMaVhWIgOiNByy67gLhxKFr7LVtjuP/Bid+v+pXXHEs3xU" +
                                                    "EKCrF3iJRgGj2jQlQo2wNB67KnDy8fDLvuTA4z1hkaYI9TtG+G0j/C4j/NwI" +
                                                    "/2QjiCCwtuegMXaIQYBsAqoBEi5Z2vudNRt21+VAbOujudDFWLQx81zQ4pBT" +
                                                    "O6NgCUYIOXDv6I51N17oI75UUkcH4FYxVu9GKk5SboN3MKfTW7br/U/23bNd" +
                                                    "c4Z1yizB2WZyTWSLOi/UhibRCPCvo37ZYvHJ8NPbG3wkFygIaNcSYZgAo9V6" +
                                                    "20hhjaYEA6MveeDwoGZERQUfJWiz2Bo2tFHnDouBWZhV2uGA/eExkJH3Fb36" +
                                                    "A2+9+s+vMSQTPF/mmjl7qdXk4hZUVsZYpMLp3j6DUij3zr3dd919fNf1rG+h" +
                                                    "RH26BhswbwFOgd4BBG95YfNfDh/ac9DnxIMFk2tsQJGlOPOl4kv4CZD+iwkJ" +
                                                    "Am+ghGmihZPT4iQ76djyuY5twFMKcCUGR8NaNapF5EFZHFAoBuMXZeesfPKD" +
                                                    "sXK7uxW4k4iWC6ZW4Nw/+ypy08s3fFrL1AgSzpMOfk4xm3xnO5qbDUPcgnbE" +
                                                    "d7y+8L7nxQeAxoE6TXkrZWxIGB6EdWAjw2IZy/2eZysxW2S6Yzx1GLnWM2Hp" +
                                                    "joMnStedeOYkszZ1QeTu9w5Rb7KjyO4F4vrVAis/nJD4dLaO+Zw42FDtHfVt" +
                                                    "ojkMyr5+oDNUrhw4Bc32Q7MSLBXMLgN4KJ4SSrx0XsHbz/6uasNrOcTXSooV" +
                                                    "TYy0imzAkSKIdGoOA4XF9W9dadszWghZOcODTELIjqIa9g/XnUszc00rLnqc" +
                                                    "4VrzeZcysPPdzyYhxVgmzVzvqd/fuPf+eS2rjrH6znDH2rXxydwMC0Sn7kWP" +
                                                    "Rj/21eU/5yMF/aRc4qvPdaISw5HWDysuM7EkhRVqyvPU1ZO9VGhK0tkCL9W4" +
                                                    "mvUSjTMnwDWWxutiT1RUIcpBSIsgGj7h8oA7KgQY0rN0cUuUqpZBN8eoPc6u" +
                                                    "ZCoWs7wes3NZH+VYpEA35BEYzMAEJlv4WmCXrIpKPNmqgK3O5a39lstfuFq1" +
                                                    "yPz2zr5AZ184cF1fT3O4u3l9B/zrCXx7baC3j+mZC3sEFnkIlN9eZtpkiflF" +
                                                    "mDXbLV6SMdKaUnFYBWkxIbkXc1nqxaGA44B3OjMAgJcBzFoxW53GaVRdYsuc" +
                                                    "z1KcnpPOaXy2xuNZ1xl61g1pCTR7K5dBr2flliGqpsioLjwMwxgfXfuVXcQ2" +
                                                    "ruHy0hQXF6a4CKmzt7mlr72rM9zW3NuWztfrztDXEKR6aPfvXE54fa0TdR0m" +
                                                    "KMYGjYnV3eQI3/CVvcdWH+Dy+yneV3e0dwT61ncHPBGdzm/xDP2+DBL4vKjC" +
                                                    "lrX/TvU7Oemz8cJWfNSofPfBPZ/u2HWZD+euvBEkIOA217jqjOFW9da9dy88" +
                                                    "a/zIbWyez/v4KEGl8lfGB637kMu3U/Cp6G3u6+pta+8Ndwd6wi1d7Z3ZOb/b" +
                                                    "kKOwshnh+7PG7ZWHN93//mP23stL8J7CdPf4D770j437XDve+kmbTncde9fL" +
                                                    "GJRRw/k4ZS7J1gqr0fqPfdt/8/D2XbZVlan7t4Aaiz72xn9e8d975MU0S/kc" +
                                                    "2WYbV1xszBIX8fR94sPL8zzdwX7IQ7hNG+Nyp6s7XFMvQU8XZtpRMy/37Byf" +
                                                    "iHQ9tNLH1zWjFsz2mr5CwX2VSxUuZpdl7tEOdqDgTKXP7/zXvL5VwxvOYLOw" +
                                                    "yGOnV+UjHXtfXH2udKeP5CQn1klHHamVmlKn02KDWjFD7UuZVBcmkS1DxNog" +
                                                    "rSAkf5Yt8/7sHo5Ol2bpq1bP0EloOsjl896+chaYPltVYqKsTuz3cBkDLOfn" +
                                                    "Z1GMdpgxP8yyQv0RZrtg9uPkyAoZfACgGLFI7giod2J091Tc5W6D3bg5Fb3r" +
                                                    "7em44CUuvzcj6KGm7VzqmdHLcYhsjEGU1mNFU4eYKT/Ngt0ezO5zsMO/dzk4" +
                                                    "/WS6OHVB6iCkqIXLnBnBCTX5bFn48ZRRxnCCUX1O5lHNNks27U78rP7VGyfq" +
                                                    "j7KtRKFswgq22RhKc2DnqnNi7+Fjr5cufJxtvXMHRNMedt6TzskHmSnnkwyP" +
                                                    "Ej2etjcHtlg06ZjAzzbYLKvHBcLcf2pqcmVKYeGrUHXIPhqLYbafN5pmaM52" +
                                                    "5toWiCiKm9PEM/sMRtb8ydNheBhPa+XNOmt7f3oTBWaibV2WYH0uyzNGNs/C" +
                                                    "Ul5CK22nshR/KW7LfVnKvILZIxnHxqPTHRsbIUUIKV1ty5IPZmRsoKZjXB6a" +
                                                    "kkOSXZlgYFh7+pthmT0iW1uS8WFz8JtZsPorZq/BOp1j1aoZPdSMKV7QXp8u" +
                                                    "aEiP2wipCNuy/OSMgIaaTnD5t8yg5TJVufj3LQcczB5kbb+XBaH3MTsyNUJH" +
                                                    "p4vQZkh3wkJW53LWjCCEmkq5JFOGVSpC+1mzH2UBh5H48anB+XAa4LBNCD5/" +
                                                    "EK7f4PKZGQEHNf2Ky0cyg+MmRBhzVd5VTzsTaIZAMoMlsPj73CI1fE/YwzEz" +
                                                    "tKitgWHugHZquhHVCWkfITU3cxmYEdBQ09VcXpoZNGcSF4RkMAllWfCpwKzI" +
                                                    "ImUcnz4tXSwJxdONpfMgPUPIvJu41GYEFtQ0xGX/lLHEYGFeL8iCSC1mVbB9" +
                                                    "5YhgqDiYOKEiVE83VNZC+gMhC+bbcv7M7CpQ00Eup95VJEOFTVvC0izALMes" +
                                                    "HjYgruMlPCTOEDIN0w2ZRkjvEFIb4rJlRuBBTU1c+s8gZC7JgsxlmF1okbM9" +
                                                    "yKSGzhoHm5XTwKYaby6H9B4hi1ZxuexMsAmkw6aMa6rjcs7phA73Cfh5lrP0" +
                                                    "DfK9lNCSBbLVmF0Ba6mouInyN5drDTnJyYLgoLVqumhhJH1EyOLPuDwyI2ih" +
                                                    "pre4fOl0IonTcU8WWPDwUAjCdIWwdKdMWWmh6ZgGNKxYK6QvCKmrseWSd2cE" +
                                                    "GtR0lMs/nVYgjTkjLZwFHxGz9bBzMS3R8DJO/3TBGAYX8gipv9SWdYdnAgym" +
                                                    "6RCXf8wMRrrVIEdEyYIIvgcWBmEAMkQyrAWFoelCA0QjAH02BLisnhFoUFMV" +
                                                    "l4WnNYTGmNNbsgCyDTPTIpUGjcgGlWBJc7U2quKbSw8o1pmAEgeNk7+wwPfI" +
                                                    "NZM+IbM/e5IenygrrJ5Y+6Z90pH4NKkoSAoHY4rifqPnus7XDTooM0iL7Pd7" +
                                                    "7DRA2GmR80/3UxDYhvMrdEPYYWu4xSKLp9JgkbNc/9y1dwNXp6ttkXz7wl34" +
                                                    "NouUphS2SLHzx11yzCK+CPou3K4n5hLXKwv7nWncZrwad3yy1XrlVD3oOvGu" +
                                                    "TznRYl8HJs6UY/b3gWFp38Sazm0nL3nI/gZDUsStW1FLYZAU2F96MKV4Lr0k" +
                                                    "o7aErvy2padmPVF0TuIMPeUbEI9ti9J/5BCI6hb7LGHrr6t/efnPJw6xdzb/" +
                                                    "A6dtrw+2KQAA");
}
