package models;

import java.util.Date;

public class Payment extends BaseClass{
private int amount;
private Date time;
private PaymentMode paymentMode;
private PaymentStatus paymentStatus;
private String refNumber;
}

/*
Payment Entity – Design Rationale

1. Transaction Amount → `amount` captures the exact fee collected for a parking session.
   - Keeps financial records precise.
   - Enables downstream reporting, auditing, and reconciliation.

2. Timestamp → `time` records when the payment was processed.
   - Useful for analytics (peak hours, revenue trends).
   - Helps in fraud detection and dispute resolution.

3. Payment Mode → `paymentMode` represents how the user paid (CASH, CARD, UPI, WALLET, etc.).
   - Makes the system extensible to support new digital payment methods.
   - Enables customer preference tracking.

4. Payment Lifecycle → `paymentStatus` (PENDING, SUCCESS, FAILED, REFUNDED).
   - Handles asynchronous flows where payment gateways confirm after some delay.
   - Provides resilience in real-world integrations.

5. Reference Number → `refNumber` is a unique identifier (transaction ID / gateway ref).
   - Ensures traceability across external systems.
   - Critical for customer support and chargeback handling.

Why this matters?
The `Payment` entity is not just about storing money-related details — it’s the **audit backbone** of the system.
By capturing mode, status, and reference details, the design ensures compliance, operational accuracy, and easy future integration with financial systems.
*/